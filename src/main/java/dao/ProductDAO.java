package dao;

import java.util.List;

import vo.ProductVO;

public interface ProductDAO {
	public int insertProduct(ProductVO product);
	public List<ProductVO> selectAllProduct();
	public ProductVO selectProduct(String product_id);
}
