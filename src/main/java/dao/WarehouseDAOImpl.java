package dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import vo.WarehouseVO;

@Component
public class WarehouseDAOImpl implements WarehouseDAO {

	@Inject
	private SqlSession session;
	
	private String namespace = "mtu.yc.sm.mybatis";
	
	@Override
	public List<WarehouseVO> selectAllWarehouse() {
		return session.selectList(namespace + ".selectAllWarehouse");
	}

	@Override
	public WarehouseVO selectWarehouseData(String product_id) {
		return session.selectOne(namespace + ".selectWarehouseData", product_id);
	}

	@Override
	public int updateWarehouse(WarehouseVO warehouseData) {
		return session.update(namespace + ".updateWarehouse", warehouseData);
	}

	@Override
	public int insertWarehouse(WarehouseVO warehouseData) {
		return session.insert(namespace + ".insertWarehouse", warehouseData);
	}
}
