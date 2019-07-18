package dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import vo.Import_historyVO;

@Component
public class ImportDAOImpl implements ImportDAO {

	@Inject
	private SqlSession session;
	
	private String namespace = "mtu.yc.sm.mybatis";
		
	@Override
	public int insertImport_history(Import_historyVO ihData) {
		return session.insert(namespace + ".insertImportHistory", ihData);
	}

	@Override
	public List<Import_historyVO> selectImportHistory() {
		return session.selectList(namespace + ".selectImportHistory");
	}

	@Override
	public int deleteImport_history(int import_num) {
		return session.delete(namespace + ".deleteImportHistory", import_num);
	}

	@Override
	public int updateImport_history(Import_historyVO ihData) {
		return session.update(namespace + ".updateImportHistory", ihData);
	}

}
