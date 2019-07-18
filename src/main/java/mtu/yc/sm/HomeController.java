package mtu.yc.sm;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro17.xapi.data.PlatformData;

@Controller
public class HomeController {
	
	@Inject
	private HomeServiceImpl service;
	
	public PlatformData data;
	
	@RequestMapping(value="/selectAllWarehouse")
	public String selectAllWarehouse(HttpServletRequest req, Model model) throws Exception {
		data = service.selectAllWarehouse();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/selectImportHistory")
	public String selectImportHistory(HttpServletRequest req, Model model) throws Exception {
		data = service.selectImportHistory();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/selectExportHistory")
	public String selectExportHistory(HttpServletRequest req, Model model) throws Exception {
		data = service.selectExportHistory();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/selectPaymentHistory")
	public String selectPaymentHistory(HttpServletRequest req, Model model) throws Exception {
		data = service.selectPaymentHistory();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/selectCollectHistory")
	public String selectCollectHistory(HttpServletRequest req, Model model) throws Exception {
		data = service.selectCollectHistory();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
}