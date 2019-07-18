package dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import vo.CollectVO;
import vo.Collect_historyVO;
import vo.PCCustomerVO;

@Component
public class CollectDAOImpl implements CollectDAO {

	@Inject
	private SqlSession session;
	
	private String namespace = "mtu.yc.sm.mybatis";

	@Override
	public CollectVO selectCollectData(String customer_id) {
		return session.selectOne(namespace + ".selectCollectData", customer_id);
	}

	@Override
	public int updateCollect(CollectVO colData) {
		return session.update(namespace + ".updateCollect", colData);
	}

	@Override
	public int insertCollect(CollectVO colData) {
		return session.insert(namespace + ".insertCollect", colData);
	}

	@Override
	public List<PCCustomerVO> selectCollectCustomer() {
		return session.selectList(namespace + ".selectCollectCustomer");
	}

	@Override
	public int insertCollectHistory(Collect_historyVO chData) {
		return session.insert(namespace + ".insertCollectHistory", chData);
	}

	@Override
	public List<Collect_historyVO> selectCollectHistory() {
		return session.selectList(namespace + ".selectCollectHistory");
	}

	@Override
	public int deleteCollectHistory(int collect_num) {
		return session.delete(namespace + ".deleteCollectHistory", collect_num);
	}

	@Override
	public int updateCollectHistory(Collect_historyVO chData) {
		return session.update(namespace + ".updateCollectHistory", chData);
	}
}
