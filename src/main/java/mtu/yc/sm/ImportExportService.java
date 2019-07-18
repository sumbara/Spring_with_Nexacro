package mtu.yc.sm;

import com.nexacro17.xapi.data.PlatformData;

import vo.CustomerVO;
import vo.ExportVO;
import vo.Export_historyVO;
import vo.ImportVO;
import vo.Import_historyVO;
import vo.ProductVO;

public interface ImportExportService {
	public int insertProduct(ProductVO product);
	public int insertCustomer(CustomerVO customer);
	public PlatformData selectAllProduct();
	public PlatformData selectAllCustomer();
	public PlatformData importProduct(ImportVO importData);
	public PlatformData selectExportProduct();
	public PlatformData exportProduct(ExportVO exportData);
	public PlatformData deleteImportHistory(Import_historyVO importData);
	public PlatformData deleteExportHistory(Export_historyVO exportData);
	public PlatformData updateImportHistory(Import_historyVO importData, int diff);
	public PlatformData updateExportHistory(Export_historyVO exportData, int diff);
}
