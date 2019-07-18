package dao;

import java.util.List;

import vo.ExportProductVO;
import vo.Export_historyVO;

public interface ExportDAO {
	public List<ExportProductVO> selectExportProduct();
	public int insertExport_history(Export_historyVO ehData);
	public List<Export_historyVO> selectExportHistory();
	public int deleteExport_history(int export_num);
	public int updateExport_history(Export_historyVO ehData);
}