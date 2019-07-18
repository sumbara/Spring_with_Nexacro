package dao;

import java.util.List;

import vo.CollectVO;
import vo.Collect_historyVO;
import vo.PCCustomerVO;

public interface CollectDAO {
	public CollectVO selectCollectData(String customer_id);
	public int updateCollect(CollectVO colData);
	public int insertCollect(CollectVO colData);
	public List<PCCustomerVO> selectCollectCustomer();
	public int insertCollectHistory(Collect_historyVO chData);
	public List<Collect_historyVO> selectCollectHistory();
	public int deleteCollectHistory(int collect_num);
	public int updateCollectHistory(Collect_historyVO chData);
}
