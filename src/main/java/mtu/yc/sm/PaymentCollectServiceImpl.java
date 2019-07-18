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
import dao.PaymentDAOImpl;
import dao.SettleDAOImpl;
import vo.CheckSettleVO;
import vo.CollectVO;
import vo.Collect_historyVO;
import vo.PCCustomerVO;
import vo.PaymentVO;
import vo.Payment_historyVO;

@Service
public class PaymentCollectServiceImpl implements PaymentCollectService {
	
	@Inject
	private PaymentDAOImpl pDao;
	@Inject
	private CollectDAOImpl coDao;
	@Inject
	private SettleDAOImpl sDao;

	DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public PlatformData selectPaymentCustomer() {
		List<PCCustomerVO> customerList = pDao.selectPaymentCustomer();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("CustomerData");
		
		ds.addColumn("Customer_id", DataTypes.STRING);
		ds.addColumn("Customer_name", DataTypes.STRING);
		ds.addColumn("Paymoney", DataTypes.INT);
		ds.addColumn("Non_paymoney", DataTypes.INT);
		
		int row = 0;
		
		for (PCCustomerVO pc : customerList) {
			row = ds.newRow();
			ds.set(row, "Customer_id", pc.getCustomer_id());
			ds.set(row, "Customer_name", pc.getCustomer_name());
			ds.set(row, "Paymoney", pc.getMoney());
			ds.set(row, "Non_paymoney", pc.getNon_money());
		}
		
		data.addDataSet(ds);
		return data;
	}

	@Override
	public PlatformData payment(Payment_historyVO paymentData) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(paymentData.getPayDate()));
		checkData.setMonth(GetYearMonth.getMonth(paymentData.getPayDate()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		// 1. 지급 테이블 내용 수정
		PaymentVO payData = pDao.selectPaymentData(paymentData.getP_History_Customer_id());
		int new_pay = paymentData.getPayMoney() + payData.getPaymoney();
		payData.setPaymoney(new_pay);
		new_pay = payData.getNon_paymoney() - paymentData.getPayMoney();
		payData.setNon_paymoney(new_pay);
		
		pDao.updatePayment(payData);
		
		// 2. 지급 이력 테이블에 추가
		Payment_historyVO payHistoryData = new Payment_historyVO();
		payHistoryData.setP_History_Customer_id(paymentData.getP_History_Customer_id());
		payHistoryData.setP_History_Customer_name(paymentData.getP_History_Customer_name());
		payHistoryData.setPayDate(paymentData.getPayDate());
		payHistoryData.setPayMoney(paymentData.getPayMoney());
		payHistoryData.setStr_payDate(sdFormat.format(paymentData.getPayDate()));
		
		pDao.insertPaymentHistory(payHistoryData);
				
		return data;
	}

	@Override
	public PlatformData selectCollectCustomer() {
		List<PCCustomerVO> customerList = coDao.selectCollectCustomer();
		
		PlatformData data = new PlatformData();
		DataSet ds = new DataSet("CustomerData");
		
		ds.addColumn("Customer_id", DataTypes.STRING);
		ds.addColumn("Customer_name", DataTypes.STRING);
		ds.addColumn("Collectmoney", DataTypes.INT);
		ds.addColumn("Non_collectmoney", DataTypes.INT);
		
		int row = 0;
		
		for (PCCustomerVO pc : customerList) {
			row = ds.newRow();
			ds.set(row, "Customer_id", pc.getCustomer_id());
			ds.set(row, "Customer_name", pc.getCustomer_name());
			ds.set(row, "Collectmoney", pc.getMoney());
			ds.set(row, "Non_collectmoney", pc.getNon_money());
		}
		
		data.addDataSet(ds);
		return data;
	}

	@Override
	public PlatformData collect(Collect_historyVO collectData) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(collectData.getCollectDate()));
		checkData.setMonth(GetYearMonth.getMonth(collectData.getCollectDate()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		// 1. 수금 테이블 내용 수정
		CollectVO colData = coDao.selectCollectData(collectData.getC_History_Customer_id());
		int new_col = collectData.getCollectMoney() + colData.getCollectmoney();
		colData.setCollectmoney(new_col);
		new_col = colData.getNon_collectmoney() - collectData.getCollectMoney();
		colData.setNon_collectmoney(new_col);
		
		coDao.updateCollect(colData);
		
		// 2. 수금 이력 테이블에 추가
		Collect_historyVO colHistoryData = new Collect_historyVO();
		colHistoryData.setC_History_Customer_id(collectData.getC_History_Customer_id());
		colHistoryData.setC_History_Customer_name(collectData.getC_History_Customer_name());
		colHistoryData.setCollectDate(collectData.getCollectDate());
		colHistoryData.setCollectMoney(collectData.getCollectMoney());
		colHistoryData.setStr_collectDate(sdFormat.format(collectData.getCollectDate()));
		
		coDao.insertCollectHistory(colHistoryData);
				
		return data;
	}

	@Override
	public PlatformData updatePaymentHistory(Payment_historyVO paymentData, int diff) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(paymentData.getPayDate()));
		checkData.setMonth(GetYearMonth.getMonth(paymentData.getPayDate()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		PaymentVO payData = pDao.selectPaymentData(paymentData.getP_History_Customer_id());
		// 1. 지급에서 차이만큼 미지급 증가
		int money = payData.getNon_paymoney() - diff;
		if (money < 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "미지급금액보다 지급액이 많습니다.");
			
			return data;
		}
		payData.setNon_paymoney(money);
		// 2. 지급에서 차이만큼 지급 감소
		money = payData.getPaymoney() + diff;
		payData.setPaymoney(money);
		// 3. 지급 테이블 수정
		pDao.updatePayment(payData);
		// 4. 지급 내역 수정
		pDao.updatePaymentHistory(paymentData);
		
		return data;
	}

	@Override
	public PlatformData deletePaymentHistory(Payment_historyVO paymentData) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(paymentData.getPayDate()));
		checkData.setMonth(GetYearMonth.getMonth(paymentData.getPayDate()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		PaymentVO payData = pDao.selectPaymentData(paymentData.getP_History_Customer_id());
		// 1. 지급에서 미지급 증가
		int money = payData.getNon_paymoney() + paymentData.getPayMoney();
		payData.setNon_paymoney(money);
		// 2. 지급에서 지급 감소
		money = payData.getPaymoney() - paymentData.getPayMoney();
		payData.setPaymoney(money);
		// 3. 지급 테이블 수정
		pDao.updatePayment(payData);
		// 4. 지급 내역 삭제
		pDao.deletePaymentHistory(paymentData.getPayment_num());
		
		return data;
	}

	@Override
	public PlatformData updateCollectHistory(Collect_historyVO collectData, int diff) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(collectData.getCollectDate()));
		checkData.setMonth(GetYearMonth.getMonth(collectData.getCollectDate()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		CollectVO colData =coDao.selectCollectData(collectData.getC_History_Customer_id());
		
		int money = colData.getNon_collectmoney() - diff;
		colData.setNon_collectmoney(money);
		if (money < 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "미수금금액보다 수금액이 많습니다.");
			
			return data;
		}
		money = colData.getCollectmoney() + diff;
		colData.setCollectmoney(money);
		
		coDao.updateCollect(colData);
		coDao.updateCollectHistory(collectData);
		
		return data;
	}

	@Override
	public PlatformData deleteCollectHistory(Collect_historyVO collectData) {
		PlatformData data = new PlatformData();
		
		CheckSettleVO checkData = new CheckSettleVO();
		checkData.setYear(GetYearMonth.getYear(collectData.getCollectDate()));
		checkData.setMonth(GetYearMonth.getMonth(collectData.getCollectDate()));
		int settleCount = sDao.checkSettle(checkData);
		
		if (settleCount > 0) {
			VariableList varList = data.getVariableList();
			varList.add("ErrorCode", 2);
			varList.add("ErrorMsg", "마감된 달입니다.");
			
			return data;
		}
		
		CollectVO colData = coDao.selectCollectData(collectData.getC_History_Customer_id());
		
		int money = colData.getNon_collectmoney() + collectData.getCollectMoney();
		colData.setNon_collectmoney(money);
		money = colData.getCollectmoney() - collectData.getCollectMoney();
		colData.setCollectmoney(money);
		
		coDao.updateCollect(colData);
		coDao.deleteCollectHistory(collectData.getCollect_num());
		
		return data;
	}
}
