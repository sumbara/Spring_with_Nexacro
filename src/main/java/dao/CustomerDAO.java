package dao;

import java.util.List;

import vo.CustomerVO;

public interface CustomerDAO {
	public int insertCustomer(CustomerVO customer);
	public List<CustomerVO> selectAllCustomer();
}
