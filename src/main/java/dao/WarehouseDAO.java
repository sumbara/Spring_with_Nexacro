package dao;

import java.util.List;

import vo.WarehouseVO;

public interface WarehouseDAO {
	public List<WarehouseVO> selectAllWarehouse();
	public WarehouseVO selectWarehouseData(String product_id);
	public int updateWarehouse(WarehouseVO warehouseData);
	public int insertWarehouse(WarehouseVO warehouseData);
}
