package mtu.yc.sm;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import com.nexacro17.xapi.tx.HttpPlatformRequest;

import vo.Collect_historyVO;
import vo.Payment_historyVO;

@Controller
public class PaymentCollectController {
	
	@Inject
	private PaymentCollectServiceImpl service;
	
	public PlatformData data;
	
	@RequestMapping(value="/selectPaymentCustomer")
	public String selectPaymentCustomer(HttpServletRequest req, Model model) throws Exception {
		data = service.selectPaymentCustomer();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/payment")
	public String payment(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("paymentData");
		Payment_historyVO paymentData = new Payment_historyVO();
		paymentData.setP_History_Customer_id(in_Data.getString(0, "Customer_id"));
		paymentData.setP_History_Customer_name(in_Data.getString(0, "Customer_name"));
		paymentData.setPayMoney(in_Data.getInt(0, "Paymoney"));
		paymentData.setPayDate(in_Data.getDateTime(0, "PayDate"));
		
		data = service.payment(paymentData);
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/selectCollectCustomer")
	public String selectCollectCustomer(HttpServletRequest req, Model model) throws Exception {
		data = service.selectCollectCustomer();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/collect")
	public String collect(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("collectData");
		Collect_historyVO collectData = new Collect_historyVO();
		collectData.setC_History_Customer_id(in_Data.getString(0, "Customer_id"));
		collectData.setC_History_Customer_name(in_Data.getString(0, "Customer_name"));
		collectData.setCollectMoney(in_Data.getInt(0, "Collectmoney"));
		collectData.setCollectDate(in_Data.getDateTime(0, "CollectDate"));
		
		data = service.collect(collectData);
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/updatePaymentHistory")
	public String updatePaymentHistory(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("updateData");
		VariableList in_Var = in_pData.getVariableList();
		int diff = in_Var.getInt("diff");
		Payment_historyVO paymentData = new Payment_historyVO();
		paymentData.setPayment_num(in_Data.getInt(0, "Payment_num"));
		paymentData.setP_History_Customer_id(in_Data.getString(0, "Customer_id"));
		paymentData.setPayMoney(in_Data.getInt(0, "Money"));
		paymentData.setPayDate(in_Data.getDateTime(0, "Date"));
		
		data = service.updatePaymentHistory(paymentData, diff);
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/deletePaymentHistory")
	public String deletePaymentHistory(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("deleteData");
		Payment_historyVO paymentData = new Payment_historyVO();
		paymentData.setPayment_num(in_Data.getInt(0, "Payment_num"));
		paymentData.setP_History_Customer_id(in_Data.getString(0, "Customer_id"));
		paymentData.setPayMoney(in_Data.getInt(0, "Money"));
		paymentData.setPayDate(in_Data.getDateTime(0, "Date"));
		
		data = service.deletePaymentHistory(paymentData);
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/updateCollectHistory")
	public String updateCollectHistory(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("updateData");
		VariableList in_Var = in_pData.getVariableList();
		int diff = in_Var.getInt("diff");
		Collect_historyVO collectData = new Collect_historyVO();
		collectData.setCollect_num(in_Data.getInt(0, "Collect_num"));
		collectData.setC_History_Customer_id(in_Data.getString(0, "Customer_id"));
		collectData.setCollectMoney(in_Data.getInt(0, "Money"));
		collectData.setCollectDate(in_Data.getDateTime(0, "Date"));
		
		data = service.updateCollectHistory(collectData, diff);
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/deleteCollectHistory")
	public String deleteCollectHistory(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("deleteData");
		Collect_historyVO collectData = new Collect_historyVO();
		collectData.setCollect_num(in_Data.getInt(0, "Collect_num"));
		collectData.setC_History_Customer_id(in_Data.getString(0, "Customer_id"));
		collectData.setCollectMoney(in_Data.getInt(0, "Money"));
		collectData.setCollectDate(in_Data.getDateTime(0, "Date"));
		
		data = service.deleteCollectHistory(collectData);
		
		model.addAttribute("data", data);
		
		return "insert";
	}
}
