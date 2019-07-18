package dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import vo.CustomerVO;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Inject
	private SqlSession session;
	
	private String namespace = "mtu.yc.sm.mybatis";
			
	@Override
	public int insertCustomer(CustomerVO customer) {
		return session.insert(namespace + ".insertCustomer", customer);
	}

	@Override
	public List<CustomerVO> selectAllCustomer() {
		return session.selectList(namespace + ".selectAllCustomer");
	}
}