package mtu.yc.sm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;

import dao.CollectDAOImpl;
import dao.CustomerDAOImpl;
import dao.ExportDAOImpl;
import dao.ImportDAOImpl;
import dao.PaymentDAOImpl;
import dao.ProductDAOImpl;
import dao.SettleDAOImpl;
import dao.WarehouseDAOImpl;
import vo.CheckSettleVO;
import vo.CollectVO;
import vo.CustomerVO;
import vo.ExportProductVO;
import vo.ExportVO;
import vo.Export_historyVO;
import vo.ImportVO;
import vo.Import_historyVO;
import vo.PaymentVO;
import vo.ProductVO;
import vo.Settle_collectVO;
import vo.Settle_paymentVO;
import vo.Settle_productVO;
import vo.WarehouseVO;

@Service
public class ImportExportServiceImpl implements ImportExportService {

	@Inject
	private ProductDAOImpl pDao;
	@Inject
	private CustomerDAOImpl cDao;
	@Inject
	private ImportDAOImpl iDao;
	@Inject
	private PaymentDAOImpl paDao;
	@Inject
	private WarehouseDAOImpl wDao;
	@Inject
	private SettleDAOImpl sDao;
	@Inject
	private ExportDAOImpl eDao;
	@Inject
	private CollectDAOImpl coDao;
	
	DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public int insertProduct(ProductVO product) {
		int result = pDao.insertProduct(product);
		
		Settle_productVO spData = new Settle_productVO();
		spData.setSp_product_id(product.getProduct_id());
		spData.setSettleState("N");
		
		sDao.insertSettleProduct(spData);
		
		return result;
	}

	@Override
	public int insertCustomer(CustomerVO customer) {
		int result = cDao.insertCustomer(customer);
		
		Settle_paymentVO spData = new Settle_paymentVO();
		Settle_collectVO scData = new Settle_collectVO();
		spData.setSp_customer_id(customer.getCustomer_id());
		spData.setSettleState("N");
		scData.setSc_customer_id(customer.getCustomer_id());
		scData.setSettleState("N");
		
		sDao.insertSettlePayment(spData);
		sDao.insertSettleCollect(scData);
		
		return result;
	}

	@Override
	public PlatformData selectAllProduct() {
		List<ProductVO> productList = pDao.selectAllProduct();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("AllProductData");
		
		ds.addColumn("Product_id", DataTypes.STRING);
		ds.addColumn("Product_name", DataTypes.STRING);
		ds.addColumn("Price", DataTypes.INT);
		
		int row = 0;
		
		for (ProductVO p : productList) {
			row = ds.newRow();
			ds.set(row, "Product_id", p.getProduct_id());
			ds.set(row, "Product_name", p.getProduct_name());
			ds.set(row, "Price", p.getPrice());
		}
		
		data.addDataSet(ds);
		return data;
	}

	@Override
	public PlatformData selectAllCustomer() {
		List<CustomerVO> customerList = cDao.selectAllCustomer();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("AllCustomerData");
		
		ds.addColumn("Customer_id", DataTypes.STRING);
		ds.addColumn("Customer_name", DataTypes.STRING);
		ds.addColumn("Phone", DataTypes.STRING);
		
		int row = 0;
		
		for (CustomerVO c : customerList) {
			row = ds.newRow();
			ds.set(row, "Customer_id", c.getCustomer_id());
			ds.set(row, "Customer_name", c.getCustomer_name());
			ds.set(row, "Phone", c.getPhone());
		}
		
		data.addDataSet(ds);
		return data;
	}
	
	@Override
	public PlatformData importProduct(ImportVO importData) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(importData.getImport_date()));
		checkData.setMonth(GetYearMonth.getMonth(importData.getImport_date()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		// 1. 구매 내역 추가
		Import_historyVO ihData = new Import_historyVO();
		ihData.setImport_customer_id(importData.getCustomer_id());
		ihData.setImport_product_id(importData.getProduct_id());
		ihData.setImport_amount(importData.getImport_amount());
		ihData.setImport_date(importData.getImport_date());
		ihData.setImport_product_name(importData.getProduct_name());
		ihData.setStr_import_date(sdFormat.format(importData.getImport_date()));
		iDao.insertImport_history(ihData);
		
		// 2. 지급 금액만큼 지급 테이블에 수정(or 추가)
		// 2-1. 지급 테이블에 해당 거래처가 존재하는지 확인
		PaymentVO payData = paDao.selectPaymentData(importData.getCustomer_id());
		if (payData != null) { 	// 2-2. 존재하면 금액 수정
			int non_payMoney = payData.getNon_paymoney();
			non_payMoney += (importData.getPrice() * importData.getImport_amount());
			payData.setNon_paymoney(non_payMoney);
			
			paDao.updatePayment(payData);
		} else { // 2-3. 존재하지 않으면 거래처와 금액 추가
			payData = new PaymentVO();
			payData.setPayment_customer_id(importData.getCustomer_id());
			payData.setPaymoney(0);
			int non_payMoney = importData.getPrice() * importData.getImport_amount();
			payData.setNon_paymoney(non_payMoney);
			
			paDao.insertPayment(payData);
		}
		
		// 3. 입고 수랑먄큼 창고 테이블에 수량 수정(or 추가)
		WarehouseVO warehouseData = wDao.selectWarehouseData(importData.getProduct_id());
		if (warehouseData != null) {	// 3-2. 창고에 존재하면 수량 수정
			int count = warehouseData.getCount();
			count += importData.getImport_amount();
			warehouseData.setCount(count);
			
			wDao.updateWarehouse(warehouseData);
		} else {	// 3-3. 창고에 존재하지 않으면 물품 추가
			warehouseData = new WarehouseVO();
			warehouseData.setProduct_id(importData.getProduct_id());
			warehouseData.setProduct_name(importData.getProduct_name());
			warehouseData.setCount(importData.getImport_amount());
			
			wDao.insertWarehouse(warehouseData);
		}
				
		return data;
	}

	@Override
	public PlatformData selectExportProduct() {
		List<ExportProductVO> exp_productList = eDao.selectExportProduct();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("ExportProductData");
		
		ds.addColumn("Product_id", DataTypes.STRING);
		ds.addColumn("Product_name", DataTypes.STRING);
		ds.addColumn("Price", DataTypes.INT);
		ds.addColumn("Count", DataTypes.INT);
		
		int row = 0;
		
		for (ExportProductVO e : exp_productList) {
			row = ds.newRow();
			ds.set(row, "Product_id", e.getProduct_id());
			ds.set(row, "Product_name", e.getProduct_name());
			ds.set(row, "Price", e.getPrice());
			ds.set(row, "Count", e.getCount());
		}
		
		data.addDataSet(ds);
		return data;
	}

	@Override
	public PlatformData exportProduct(ExportVO exportData) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(exportData.getExport_date()));
		checkData.setMonth(GetYearMonth.getMonth(exportData.getExport_date()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		// 1. 판매 내역 추가
		Export_historyVO ehData = new Export_historyVO();
		ehData.setExport_customer_id(exportData.getCustomer_id());
		ehData.setExport_product_id(exportData.getProduct_id());
		ehData.setExport_amount(exportData.getExport_amount());
		ehData.setExport_date(exportData.getExport_date());
		ehData.setExport_product_name(exportData.getProduct_name());
		ehData.setStr_export_date(sdFormat.format(exportData.getExport_date()));
		eDao.insertExport_history(ehData);
		
		// 2. 수금 금액만큼 수금 테이블에 수정(or 추가)
		CollectVO colData = coDao.selectCollectData(exportData.getCustomer_id());
		if (colData != null) {
			int non_collectMoney = colData.getNon_collectmoney();
			non_collectMoney += (exportData.getPrice() * exportData.getExport_amount());
			colData.setNon_collectmoney(non_collectMoney);
			
			coDao.updateCollect(colData);
		} else {
			colData = new CollectVO();
			colData.setCollect_customer_id(exportData.getCustomer_id());
			colData.setCollectmoney(0);
			int non_collectMoney = exportData.getPrice() * exportData.getExport_amount();
			colData.setNon_collectmoney(non_collectMoney);
			
			coDao.insertCollect(colData);
		}
		
		// 3. 출고 수량만큼 창고테이블에서 제거
		WarehouseVO warehouseData = wDao.selectWarehouseData(exportData.getProduct_id());
		int count = warehouseData.getCount();
		count -= exportData.getExport_amount();
		warehouseData.setCount(count);
		
		wDao.updateWarehouse(warehouseData);
				
		return data;
	}

	@Override
	public PlatformData deleteImportHistory(Import_historyVO importData) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(importData.getImport_date()));
		checkData.setMonth(GetYearMonth.getMonth(importData.getImport_date()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		// 1. 창고에서 수량 줄이기
		WarehouseVO warehouseData = wDao.selectWarehouseData(importData.getImport_product_id());
		int count = warehouseData.getCount() - importData.getImport_amount();
		warehouseData.setCount(count);
		wDao.updateWarehouse(warehouseData);
		
		// 2. 지급에서 금액 감소
		ProductVO productData = pDao.selectProduct(importData.getImport_product_id());
		PaymentVO payData = paDao.selectPaymentData(importData.getImport_customer_id());
		int money = payData.getNon_paymoney() - (importData.getImport_amount() * productData.getPrice());
		payData.setNon_paymoney(money);
		paDao.updatePayment(payData);
		
		// 3. 입고 내역 삭제
		iDao.deleteImport_history(importData.getImport_num());
		
		return data;
	}

	@Override
	public PlatformData deleteExportHistory(Export_historyVO exportData) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(exportData.getExport_date()));
		checkData.setMonth(GetYearMonth.getMonth(exportData.getExport_date()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		WarehouseVO warehouseData = wDao.selectWarehouseData(exportData.getExport_product_id());
		int count = warehouseData.getCount() + exportData.getExport_amount();
		warehouseData.setCount(count);
		wDao.updateWarehouse(warehouseData);
		
		ProductVO productData = pDao.selectProduct(exportData.getExport_product_id());
		CollectVO collectData = coDao.selectCollectData(exportData.getExport_customer_id());
		int money = collectData.getNon_collectmoney() - (exportData.getExport_amount() * productData.getPrice());
		collectData.setNon_collectmoney(money);
		coDao.updateCollect(collectData);
		
		eDao.deleteExport_history(exportData.getExport_num());
		
		return data;
	}

	@Override
	public PlatformData updateImportHistory(Import_historyVO importData, int diff) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(importData.getImport_date()));
		checkData.setMonth(GetYearMonth.getMonth(importData.getImport_date()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		WarehouseVO warehouseData = wDao.selectWarehouseData(importData.getImport_product_id());
		int count = warehouseData.getCount() + diff;
		warehouseData.setCount(count);
		wDao.updateWarehouse(warehouseData);
		
		ProductVO productData = pDao.selectProduct(importData.getImport_product_id());
		PaymentVO payData = paDao.selectPaymentData(importData.getImport_customer_id());
		int money = payData.getNon_paymoney() + (diff * productData.getPrice());
		payData.setNon_paymoney(money);
		paDao.updatePayment(payData);
		
		iDao.updateImport_history(importData);
		
		return data;
	}

	@Override
	public PlatformData updateExportHistory(Export_historyVO exportData, int diff) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(exportData.getExport_date()));
		checkData.setMonth(GetYearMonth.getMonth(exportData.getExport_date()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		WarehouseVO warehouseData = wDao.selectWarehouseData(exportData.getExport_product_id());
		int count = warehouseData.getCount() - diff;
		if (count < 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "재고량보다 출고량이 많습니다.");
			
			return data;
		}
		warehouseData.setCount(count);
		wDao.updateWarehouse(warehouseData);
		
		ProductVO productData = pDao.selectProduct(exportData.getExport_product_id());
		CollectVO collectData = coDao.selectCollectData(exportData.getExport_customer_id());
		int money = collectData.getNon_collectmoney() + (diff * productData.getPrice());
		collectData.setNon_collectmoney(money);
		coDao.updateCollect(collectData);
		
		eDao.updateExport_history(exportData);
		
		return data;
	}
	
}
