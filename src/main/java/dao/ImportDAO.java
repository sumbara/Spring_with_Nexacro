package dao;

import java.util.List;

import vo.Import_historyVO;

public interface ImportDAO {
	public int insertImport_history(Import_historyVO ihData);
	public List<Import_historyVO> selectImportHistory();
	public int deleteImport_history(int import_num);
	public int updateImport_history(Import_historyVO ihData);
}
