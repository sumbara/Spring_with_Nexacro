package mtu.yc.sm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;

import dao.SettleDAOImpl;
import vo.CheckSettleVO;
import vo.ExtractSettleVO;
import vo.InsertSettleVO;
import vo.Settle_collectVO;
import vo.Settle_paymentVO;
import vo.Settle_productVO;

@Service
public class SettlementServiceImpl implements SettlementService {

	@Inject
	private SettleDAOImpl sDao;

	@Override
	public PlatformData selectSettlementData() {
		List<Settle_productVO> productList = sDao.selectAllSettleProduct();
		List<Settle_paymentVO> paymentList = sDao.selectAllSettlePayment();
		List<Settle_collectVO> collectList = sDao.selectAllSettleCollect();
		
		PlatformData data = new PlatformData();
		
		DataSet ds1 = new DataSet("ProductData");
		ds1.addColumn("Year", DataTypes.INT);
		ds1.addColumn("Month", DataTypes.INT);
		ds1.addColumn("Product_id", DataTypes.STRING);
		ds1.addColumn("CarriedOverAmount", DataTypes.INT);
		ds1.addColumn("TotalImport", DataTypes.INT);
		ds1.addColumn("TotalExport", DataTypes.INT);
		ds1.addColumn("TotalAmount", DataTypes.INT);
		ds1.addColumn("SettleState", DataTypes.STRING);
		
		DataSet ds2 = new DataSet("PaymentData");
		ds2.addColumn("Year", DataTypes.INT);
		ds2.addColumn("Month", DataTypes.INT);
		ds2.addColumn("Customer_id", DataTypes.STRING);
		ds2.addColumn("CarriedOverMoney", DataTypes.INT);
		ds2.addColumn("TotalPayMoney", DataTypes.INT);
		ds2.addColumn("TotalNon_PayMoney", DataTypes.INT);
		ds2.addColumn("TotalMoney", DataTypes.INT);
		ds2.addColumn("SettleState", DataTypes.STRING);
		
		DataSet ds3 = new DataSet("CollectData");
		ds3.addColumn("Year", DataTypes.INT);
		ds3.addColumn("Month", DataTypes.INT);
		ds3.addColumn("Customer_id", DataTypes.STRING);
		ds3.addColumn("CarriedOverMoney", DataTypes.INT);
		ds3.addColumn("TotalCollectMoney", DataTypes.INT);
		ds3.addColumn("TotalNon_CollectMoney", DataTypes.INT);
		ds3.addColumn("TotalMoney", DataTypes.INT);
		ds3.addColumn("SettleState", DataTypes.STRING);
		
		int row = 0;
		
		for (Settle_productVO pr : productList) {
			row = ds1.newRow();
			ds1.set(row, "Year", pr.getYear());
			ds1.set(row, "Month", pr.getMonth());
			ds1.set(row, "Product_id", pr.getSp_product_id());
			ds1.set(row, "CarriedOverAmount", pr.getCarriedOverAmount());
			ds1.set(row, "TotalImport", pr.getTotalImport());
			ds1.set(row, "TotalExport", pr.getTotalExport());
			ds1.set(row, "TotalAmount", pr.getTotalAmount());
			ds1.set(row, "SettleState", pr.getSettleState());
		}
		
		row = 0;
		for (Settle_paymentVO pa : paymentList) {
			row = ds2.newRow();
			ds2.set(row, "Year", pa.getYear());
			ds2.set(row, "Month", pa.getMonth());
			ds2.set(row, "Customer_id", pa.getSp_customer_id());
			ds2.set(row, "CarriedOverMoney", pa.getCarriedOverMoney());
			ds2.set(row, "TotalPayMoney", pa.getTotalPayMoney());
			ds2.set(row, "TotalNon_PayMoney", pa.getTotalNon_paymoney());
			ds2.set(row, "TotalMoney", pa.getTotalMoney());
			ds2.set(row, "SettleState", pa.getSettleState());
		}
		
		row = 0;
		for (Settle_collectVO co : collectList) {
			row = ds3.newRow();
			ds3.set(row, "Year", co.getYear());
			ds3.set(row, "Month", co.getMonth());
			ds3.set(row, "Customer_id", co.getSc_customer_id());
			ds3.set(row, "CarriedOverMoney", co.getCarriedOverMoney());
			ds3.set(row, "TotalCollectMoney", co.getTotalCollectMoney());
			ds3.set(row, "TotalNon_CollectMoney", co.getTotalNon_collectMoney());
			ds3.set(row, "TotalMoney", co.getTotalMoney());
			ds3.set(row, "SettleState", co.getSettleState());
		}
		
		data.addDataSet(ds1);
		data.addDataSet(ds2);
		data.addDataSet(ds3);
		
		return data;
	}

	@Override
	public PlatformData settlement(int year, int month) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(year);
		checkData.setMonth(month);
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		List<Settle_productVO> sprList = sDao.selectNonSettleProduct();
		List<Settle_paymentVO> spaList = sDao.selectNonSettlePayment();
		List<Settle_collectVO> scoList = sDao.selectNonSettleCollect();
		
		ExtractSettleVO exData = new ExtractSettleVO();
		String ex = "";
		String now = "";
		int new_year;
		int new_month;
		
		if ((month + 1) > 12) {
			new_year = year + 1;
			new_month = 1;
		} else {
			new_year = year;
			new_month = month + 1;
		}
		
		// 1. 품목 마감
		Settle_productVO newProduct = new Settle_productVO();
		for (Settle_productVO p : sprList) {
			exData.setProduct_id(p.getSp_product_id());
			ex = p.getYear() + "-" + p.getMonth() + "-1";
			now = year + "-" + (month+1) + "-1";
			exData.setEx_yearMonth(ex);
			exData.setNow_yearMonth(now);
			int totalImport = sDao.selectTotalImport(exData);
			int totalExport = sDao.selectTotalExport(exData);
			p.setYear(year);
			p.setMonth(month);
			p.setTotalImport(totalImport);
			p.setTotalExport(totalExport);
			int totalAmount = p.getCarriedOverAmount() - totalExport + totalImport;
			p.setTotalAmount(totalAmount);
			p.setSettleState("Y");
			
			newProduct.setYear(new_year);
			newProduct.setMonth(new_month);
			newProduct.setSp_product_id(p.getSp_product_id());
			newProduct.setCarriedOverAmount(totalAmount);
			newProduct.setSettleState("N");
			
			sDao.updateSettleProduct(p);
			sDao.insertSettleProduct(newProduct);
		}
		
		// 2. 지급 마감
		Settle_paymentVO newPay = new Settle_paymentVO();
		for (Settle_paymentVO s : spaList) {
			exData.setCustomer_id(s.getSp_customer_id());
			ex = s.getYear() + "-" + s.getMonth() + "-1";
			now = year + "-" + (month+1) + "-1";
			exData.setEx_yearMonth(ex);
			exData.setNow_yearMonth(now);
			int totalPay = sDao.selectTotalPay(exData);
			int totalNonPay = sDao.selectTotalNonPay(exData);
			s.setYear(year);
			s.setMonth(month);
			s.setTotalPayMoney(totalPay);
			s.setTotalNon_paymoney(totalNonPay);
			int totalMoney = s.getCarriedOverMoney() - totalPay + totalNonPay;
			s.setTotalMoney(totalMoney);
			s.setSettleState("Y");
			
			newPay.setYear(new_year);
			newPay.setMonth(new_month);
			newPay.setSp_customer_id(s.getSp_customer_id());
			newPay.setCarriedOverMoney(totalMoney);
			newPay.setSettleState("N");
			
			sDao.updateSettlePayment(s);
			sDao.insertSettlePayment(newPay);
		}
		
		// 3. 수금 마감
		Settle_collectVO newCollect = new Settle_collectVO();
		for (Settle_collectVO s : scoList) {
			exData.setCustomer_id(s.getSc_customer_id());
			ex = s.getYear() + "-" + s.getMonth() + "-1";
			now = year + "-" + (month + 1) + "-1";
			exData.setEx_yearMonth(ex);
			exData.setNow_yearMonth(now);
			int totalCollect = sDao.selectTotalCollect(exData);
			int totalNonCollect = sDao.selectTotalNonCollect(exData);
			s.setYear(year);
			s.setMonth(month);
			s.setTotalCollectMoney(totalCollect);
			s.setTotalNon_collectMoney(totalNonCollect);
			int totalMoney = s.getCarriedOverMoney() - totalCollect + totalNonCollect;
			s.setTotalMoney(totalMoney);
			s.setSettleState("Y");
			
			newCollect.setYear(new_year);
			newCollect.setMonth(new_month);
			newCollect.setSc_customer_id(s.getSc_customer_id());
			newCollect.setCarriedOverMoney(totalMoney);
			newCollect.setSettleState("N");
			
			sDao.updateSettleCollect(s);
			sDao.insertSettleCollect(newCollect);
		}
		
		return data;
	}

	@Override
	public PlatformData cancelSettlement(int year, int month) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(year);
		checkData.setMonth(month);
		
		int settleCount = sDao.checkSettleCancel(checkData);
		VariableList varList = data.getVariableList();
		
		if (settleCount == 0) {
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감하지 않은 달입니다.");
			
			return data;
		}
		
		int new_year;
		int new_month;
		
		if ((month + 1) > 12) {
			new_year = year + 1;
			new_month = 1;
		} else {
			new_year = year;
			new_month = month + 1;
		}
		
		checkData.setYear(new_year);
		checkData.setMonth(new_month);
		
		List<Settle_productVO> sprList = sDao.selectCancelSettleProduct(checkData);
		List<Settle_paymentVO> spaList = sDao.selectCancelSettlePayment(checkData);
		List<Settle_collectVO> scoList = sDao.selectCancelSettleCollect(checkData);
		
		// 마감 취소 달 이후 마감 달이 존재할 경우
		if (sprList.size() < settleCount) {
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "이후 마감달부터 취소해주세요.");
			
			return data;
		}
		
		for (Settle_productVO p : sprList) {
			Settle_productVO spData = new Settle_productVO();
			spData.setSp_product_id(p.getSp_product_id());
			spData.setYear(new_year);
			spData.setMonth(new_month);
			sDao.deleteSettleProduct(spData);
			
			spData.setYear(year);
			spData.setMonth(month);
			sDao.deleteSettleProduct(spData);
		}
		
		for (Settle_paymentVO p : spaList) {
			Settle_paymentVO spayData = new Settle_paymentVO();
			spayData.setSp_customer_id(p.getSp_customer_id());
			spayData.setYear(new_year);
			spayData.setMonth(new_month);
			sDao.deleteSettlePayment(spayData);
			
			spayData.setYear(year);
			spayData.setMonth(month);
			sDao.deleteSettlePayment(spayData);
		}
			
		for (Settle_collectVO c : scoList) {
			Settle_collectVO scolData = new Settle_collectVO();
			scolData.setSc_customer_id(c.getSc_customer_id());
			scolData.setYear(new_year);
			scolData.setMonth(new_month);
			
			sDao.deleteSettleCollect(scolData);
			
			scolData.setYear(year);
			scolData.setMonth(month);
			sDao.deleteSettleCollect(scolData);
		}
		
		// 마지막 달 이후 새로 추가
		InsertSettleVO lastSettleDay = sDao.lastSettleDay();
		
		if (lastSettleDay == null) { // 마감된 데이터가 하나도 없을 경우
			for (Settle_productVO p : sprList) {
				Settle_productVO spData = new Settle_productVO();
				spData.setYear(0);
				spData.setMonth(1);
				spData.setSp_product_id(p.getSp_product_id());
				spData.setSettleState("N");
				
				sDao.insertSettleProduct(spData);
			}
			
			for (Settle_paymentVO p : spaList) {
				Settle_paymentVO spayData = new Settle_paymentVO();
				spayData.setYear(0);
				spayData.setMonth(1);
				spayData.setSp_customer_id(p.getSp_customer_id());
				spayData.setSettleState("N");
				
				sDao.insertSettlePayment(spayData);
			}
			
			for (Settle_collectVO c : scoList) {
				Settle_collectVO scolData = new Settle_collectVO();
				scolData.setYear(0);
				scolData.setMonth(1);
				scolData.setSc_customer_id(c.getSc_customer_id());
				scolData.setSettleState("N");
				
				sDao.insertSettleCollect(scolData);
			}
			
		} else {
			int last_year = lastSettleDay.getYear();
			int last_month = lastSettleDay.getMonth();
			if (lastSettleDay.getMonth() == 12) {
				last_year++;
				last_month = 1;
			} else {
				last_month++;
			}
					
			for (Settle_productVO p : sprList) {
				Settle_productVO spData = new Settle_productVO();
				spData.setYear(last_year);
				spData.setMonth(last_month);
				spData.setSp_product_id(p.getSp_product_id());
				lastSettleDay.setProduct_id(p.getSp_product_id());
				int carriedOverAmount = sDao.selectSettleTotalAmount(lastSettleDay);
				spData.setCarriedOverAmount(carriedOverAmount);
				spData.setSettleState("N");
				
				sDao.insertSettleProduct(spData);
			}
			
			for (Settle_paymentVO p : spaList) {
				Settle_paymentVO spayData = new Settle_paymentVO();
				spayData.setYear(last_year);
				spayData.setMonth(last_month);
				spayData.setSp_customer_id(p.getSp_customer_id());
				lastSettleDay.setCustomer_id(p.getSp_customer_id());
				int carriedOverMoney = sDao.selectSettleTotalPayMoney(lastSettleDay);
				spayData.setCarriedOverMoney(carriedOverMoney);
				spayData.setSettleState("N");
				
				sDao.insertSettlePayment(spayData);
			}
				
			for (Settle_collectVO c : scoList) {
				Settle_collectVO scolData = new Settle_collectVO();
				scolData.setYear(last_year);
				scolData.setMonth(last_month);
				scolData.setSc_customer_id(c.getSc_customer_id());
				lastSettleDay.setCustomer_id(c.getSc_customer_id());
				int carriedOverMoney = sDao.selectSettleTotalCollectMoney(lastSettleDay);
				scolData.setCarriedOverMoney(carriedOverMoney);
				scolData.setSettleState("N");
				
				sDao.insertSettleCollect(scolData);
			}
		}
		
		return data;
	}	
}