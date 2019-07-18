package mtu.yc.sm;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import com.nexacro17.xapi.tx.HttpPlatformRequest;

@Controller
public class SettlementController {
	
	@Inject
	private SettlementServiceImpl service;
	
	public PlatformData data;
	
	@RequestMapping(value="/selectSettlement")
	public String selectSettlmentData(HttpServletRequest req, Model model) throws Exception {
		data = service.selectSettlementData();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/settlement")
	public String settlement(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		data = pReq.getData();
		
		VariableList in_Var = data.getVariableList();
		int year = in_Var.getInt("year");
		int month = in_Var.getInt("month");
		
		data = service.settlement(year, month);
		
		model.addAttribute("data", data);
		return "insert";
	}
	
	@RequestMapping(value="/cancelSettlement")
	public String cancelSettlement(HttpServletRequest req, Model model) throws Exception { 
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		data = pReq.getData();
		
		VariableList in_Var = data.getVariableList();
		int year = in_Var.getInt("year");
		int month = in_Var.getInt("month");
		
		data = service.cancelSettlement(year, month);
		
		model.addAttribute("data", data);
		return "insert";
	}
}
