package dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import vo.ExportProductVO;
import vo.Export_historyVO;

@Component
public class ExportDAOImpl implements ExportDAO {

	@Inject
	private SqlSession session;
	
	private String namespace = "mtu.yc.sm.mybatis";

	@Override
	public List<ExportProductVO> selectExportProduct() {
		return session.selectList(namespace + ".selectExportProduct");
	}

	@Override
	public int insertExport_history(Export_historyVO ehData) {
		return session.insert(namespace + ".insertExportHistory", ehData);
	}

	@Override
	public List<Export_historyVO> selectExportHistory() {
		return session.selectList(namespace + ".selectExportHistory");
	}

	@Override
	public int deleteExport_history(int export_num) {
		return session.delete(namespace + ".deleteExportHistory", export_num);
	}

	@Override
	public int updateExport_history(Export_historyVO ehData) {
		return session.update(namespace + ".updateExportHistory", ehData);
	}
}
