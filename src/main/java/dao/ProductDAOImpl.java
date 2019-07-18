package dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import vo.ProductVO;

@Component
public class ProductDAOImpl implements ProductDAO {

	@Inject
	private SqlSession session;
	
	private String namespace = "mtu.yc.sm.mybatis";
	
	@Override
	public int insertProduct(ProductVO product) {
		return session.insert(namespace + ".insertProduct", product);
	}

	@Override
	public List<ProductVO> selectAllProduct() {
		return session.selectList(namespace + ".selectAllProduct");
	}

	@Override
	public ProductVO selectProduct(String product_id) {
		return session.selectOne(namespace + ".selectProduct", product_id);
	}
}
