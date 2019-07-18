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

import vo.CustomerVO;
import vo.ExportVO;
import vo.Export_historyVO;
import vo.ImportVO;
import vo.Import_historyVO;
import vo.ProductVO;

@Controller
public class ImportExportController {
	
	@Inject
	private ImportExportServiceImpl service;
	
	public PlatformData data;
	
	@RequestMapping(value="/insertProduct")
	public String insertProduct(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("productData");
		ProductVO product = new ProductVO();
		product.setProduct_id(in_Data.getString(0, "Product_id"));
		product.setProduct_name(in_Data.getString(0, "Product_name"));
		product.setPrice(in_Data.getInt(0, "Price"));
		
		service.insertProduct(product);
		
		data = new PlatformData();
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/insertCustomer")
	public String insertCustomer(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("customerData");
		CustomerVO customer = new CustomerVO();
		customer.setCustomer_id(in_Data.getString(0, "Customer_id"));
		customer.setCustomer_name(in_Data.getString(0, "Customer_name"));
		customer.setPhone(in_Data.getString(0, "Phone"));
		
		service.insertCustomer(customer);
		
		data = new PlatformData();
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/selectAllProduct")
	public String selectAllProduct(HttpServletRequest req, Model model) throws Exception {
		data = service.selectAllProduct();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/selectAllCustomer")
	public String selectAllCustomer(HttpServletRequest req, Model model) throws Exception {
		data = service.selectAllCustomer();
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/importProduct")
	public String importProduct(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("importData");
		ImportVO importData = new ImportVO();
		importData.setProduct_id(in_Data.getString(0, "Product_id"));
		importData.setProduct_name(in_Data.getString(0, "Product_name"));
		importData.setPrice(in_Data.getInt(0, "Price"));
		importData.setCustomer_id(in_Data.getString(0, "Customer_id"));
		importData.setImport_amount(in_Data.getInt(0, "Import_amount"));
		importData.setImport_date(in_Data.getDateTime(0, "Import_date"));
		
		data = service.importProduct(importData);
	
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/selectExportProduct")
	public String selectExportProduct(HttpServletRequest req, Model model) throws Exception {
		data = service.selectExportProduct();
		
		model.addAttribute("data", data);		
		
		return "insert";
	}
	
	@RequestMapping(value="/exportProduct")
	public String exportProduct(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("exportData");
		ExportVO exportData = new ExportVO();
		exportData.setProduct_id(in_Data.getString(0, "Product_id"));
		exportData.setProduct_name(in_Data.getString(0, "Product_name"));
		exportData.setPrice(in_Data.getInt(0, "Price"));
		exportData.setCustomer_id(in_Data.getString(0, "Customer_id"));
		exportData.setExport_amount(in_Data.getInt(0, "Export_amount"));
		exportData.setExport_date(in_Data.getDateTime(0, "Export_date"));
		
		data = service.exportProduct(exportData);
		
		model.addAttribute("data", data);
		
		return "insert";
	}
	
	@RequestMapping(value="/deleteImportHistory")
	public String deleteImportHistory(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("deleteData");
		Import_historyVO importData = new Import_historyVO();
		importData.setImport_num(in_Data.getInt(0, "Import_num"));
		importData.setImport_customer_id(in_Data.getString(0, "Customer_id"));
		importData.setImport_product_id(in_Data.getString(0, "Product_id"));
		importData.setImport_amount(in_Data.getInt(0, "Amount"));
		importData.setImport_date(in_Data.getDateTime(0, "Date"));
		
		data = service.deleteImportHistory(importData);
		
		model.addAttribute("data", data);
		return "insert";
	}
	
	@RequestMapping(value="/deleteExportHistory")
	public String deleteExportHistory(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("deleteData");
		Export_historyVO exportData = new Export_historyVO();
		exportData.setExport_num(in_Data.getInt(0, "Export_num"));
		exportData.setExport_customer_id(in_Data.getString(0, "Customer_id"));
		exportData.setExport_product_id(in_Data.getString(0, "Product_id"));
		exportData.setExport_amount(in_Data.getInt(0, "Amount"));
		exportData.setExport_date(in_Data.getDateTime(0, "Date"));
		
		data = service.deleteExportHistory(exportData);

		model.addAttribute("data", data);
		return "insert";
	}
	
	@RequestMapping(value="/updateImportHistory")
	public String updateImportHistory(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("updateData");
		VariableList in_Var = in_pData.getVariableList();
		int diff = in_Var.getInt("diff");
		Import_historyVO importData = new Import_historyVO();
		importData.setImport_num(in_Data.getInt(0, "Import_num"));
		importData.setImport_customer_id(in_Data.getString(0, "Customer_id"));
		importData.setImport_product_id(in_Data.getString(0, "Product_id"));
		importData.setImport_amount(in_Data.getInt(0, "Amount"));
		importData.setImport_date(in_Data.getDateTime(0, "Date"));
		
		data = service.updateImportHistory(importData, diff);
		
		model.addAttribute("data", data);
		return "insert";
	}
	
	@RequestMapping(value="/updateExportHistory")
	public String updateExportHistory(HttpServletRequest req, Model model) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		pReq.receiveData();
		PlatformData in_pData = pReq.getData();
		
		DataSet in_Data = in_pData.getDataSet("updateData");
		VariableList in_Var = in_pData.getVariableList();
		int diff = in_Var.getInt("diff");
		Export_historyVO exportData = new Export_historyVO();
		exportData.setExport_num(in_Data.getInt(0, "Export_num"));
		exportData.setExport_customer_id(in_Data.getString(0, "Customer_id"));
		exportData.setExport_product_id(in_Data.getString(0, "Product_id"));
		exportData.setExport_amount(in_Data.getInt(0, "Amount"));
		exportData.setExport_date(in_Data.getDateTime(0, "Date"));
		
		data = service.updateExportHistory(exportData, diff);
		
		model.addAttribute("data", data);
		return "insert";
	}
}
