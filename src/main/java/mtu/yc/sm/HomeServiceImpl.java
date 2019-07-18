package mtu.yc.sm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;

import dao.CollectDAOImpl;
import dao.ExportDAOImpl;
import dao.ImportDAOImpl;
import dao.PaymentDAOImpl;
import dao.WarehouseDAOImpl;
import vo.Collect_historyVO;
import vo.Export_historyVO;
import vo.Import_historyVO;
import vo.Payment_historyVO;
import vo.WarehouseVO;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Inject
	private WarehouseDAOImpl wDao;
	@Inject
	private ImportDAOImpl iDao;
	@Inject
	private ExportDAOImpl eDao;
	@Inject
	private PaymentDAOImpl pDao;
	@Inject
	private CollectDAOImpl coDao;
	
	@Override
	public PlatformData selectAllWarehouse() {
		List<WarehouseVO> warehouseList = wDao.selectAllWarehouse();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("AllWarehouseData");
		
		ds.addColumn("Product_id", DataTypes.STRING);
		ds.addColumn("Product_name", DataTypes.STRING);
		ds.addColumn("Count", DataTypes.INT);
		
		int row = 0;
		
		for (WarehouseVO w : warehouseList) {
			row = ds.newRow();
			ds.set(row, "Product_id", w.getProduct_id());
			ds.set(row, "Product_name", w.getProduct_name());
			ds.set(row, "Count", w.getCount());
		}
		
		data.addDataSet(ds);
		return data;
	}

	@Override
	public PlatformData selectImportHistory() {
		List<Import_historyVO> importHistoryList = iDao.selectImportHistory();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("ImportHistoryData");
		
		ds.addColumn("Import_num", DataTypes.INT);
		ds.addColumn("Import_Customer_id", DataTypes.STRING);
		ds.addColumn("Import_Customer_name", DataTypes.STRING);
		ds.addColumn("Import_Product_id", DataTypes.STRING);
		ds.addColumn("Import_Product_name", DataTypes.STRING);
		ds.addColumn("Import_Amount", DataTypes.INT);
		ds.addColumn("Import_Date", DataTypes.DATE);
		
		int row = 0;
		
		for (Import_historyVO i : importHistoryList) {
			row = ds.newRow();
			ds.set(row, "Import_num", i.getImport_num());
			ds.set(row, "Import_Customer_id", i.getImport_customer_id());
			ds.set(row, "Import_Customer_name", i.getImport_customer_name());
			ds.set(row, "Import_Product_id", i.getImport_product_id());
			ds.set(row, "Import_Product_name", i.getImport_product_name());
			ds.set(row, "Import_Amount", i.getImport_amount());
			ds.set(row, "Import_Date", i.getImport_date());
		}
		
		data.addDataSet(ds);
		return data;
	}

	@Override
	public PlatformData selectExportHistory() {
		List<Export_historyVO> exportHistoryList = eDao.selectExportHistory();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("ExportHistoryData");
		
		ds.addColumn("Export_num", DataTypes.INT);
		ds.addColumn("Export_Customer_id", DataTypes.STRING);
		ds.addColumn("Export_Customer_name", DataTypes.STRING);
		ds.addColumn("Export_Product_id", DataTypes.STRING);
		ds.addColumn("Export_Product_name", DataTypes.STRING);
		ds.addColumn("Export_Amount", DataTypes.INT);
		ds.addColumn("Export_Date", DataTypes.DATE);
		
		int row = 0;
		
		for (Export_historyVO e : exportHistoryList) {
			row = ds.newRow();
			ds.set(row, "Export_num", e.getExport_num());
			ds.set(row, "Export_Customer_id", e.getExport_customer_id());
			ds.set(row, "Export_Customer_name", e.getExport_customer_name());
			ds.set(row, "Export_Product_id", e.getExport_product_id());
			ds.set(row, "Export_Product_name", e.getExport_product_name());
			ds.set(row, "Export_Amount", e.getExport_amount());
			ds.set(row, "Export_Date", e.getExport_date());
		}
		
		data.addDataSet(ds);
		return data;
	}

	@Override
	public PlatformData selectPaymentHistory() {
		List<Payment_historyVO> paymentHistoryList = pDao.selectPaymentHistory();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("HistoryData");
		
		ds.addColumn("Payment_num", DataTypes.INT);
		ds.addColumn("Customer_id", DataTypes.STRING);
		ds.addColumn("Customer_name", DataTypes.STRING);
		ds.addColumn("Paymoney", DataTypes.INT);
		ds.addColumn("PayDate", DataTypes.DATE);
		
		int row = 0;
		
		for (Payment_historyVO p : paymentHistoryList) {
			row = ds.newRow();
			ds.set(row, "Payment_num", p.getPayment_num());
			ds.set(row, "Customer_id", p.getP_History_Customer_id());
			ds.set(row, "Customer_name", p.getP_History_Customer_name());
			ds.set(row, "Paymoney", p.getPayMoney());
			ds.set(row, "PayDate", p.getPayDate());
		}
		
		data.addDataSet(ds);
		return data;
	}

	@Override
	public PlatformData selectCollectHistory() {
		List<Collect_historyVO> collectHistoryList = coDao.selectCollectHistory();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("HistoryData");
		
		ds.addColumn("Collect_num", DataTypes.INT);
		ds.addColumn("Customer_id", DataTypes.STRING);
		ds.addColumn("Customer_name", DataTypes.STRING);
		ds.addColumn("CollectMoney", DataTypes.INT);
		ds.addColumn("CollectDate", DataTypes.DATE);
		
		int row = 0;
		
		for (Collect_historyVO c : collectHistoryList) {
			row = ds.newRow();
			ds.set(row, "Collect_num", c.getCollect_num());
			ds.set(row, "Customer_id", c.getC_History_Customer_id());
			ds.set(row, "Customer_name", c.getC_History_Customer_name());
			ds.set(row, "CollectMoney", c.getCollectMoney());
			ds.set(row, "CollectDate", c.getCollectDate());
		}
		
		data.addDataSet(ds);
		return data;
	}

}
