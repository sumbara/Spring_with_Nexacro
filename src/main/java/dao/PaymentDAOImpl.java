package dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import vo.PCCustomerVO;
import vo.PaymentVO;
import vo.Payment_historyVO;

@Component
public class PaymentDAOImpl implements PaymentDAO {

	@Inject
	private SqlSession session;
	
	private String namespace = "mtu.yc.sm.mybatis";
	
	@Override
	public PaymentVO selectPaymentData(String customer_id) {
		return session.selectOne(namespace + ".selectPaymentData", customer_id);
	}

	@Override
	public int updatePayment(PaymentVO payData) {
		return session.update(namespace + ".updatePayment", payData);
	}

	@Override
	public int insertPayment(PaymentVO payData) {
		return session.insert(namespace + ".insertPayment", payData);
	}

	@Override
	public List<PCCustomerVO> selectPaymentCustomer() {
		return session.selectList(namespace + ".selectPaymentCustomer");
	}

	@Override
	public int insertPaymentHistory(Payment_historyVO phData) {
		return session.insert(namespace + ".insertPaymentHistory", phData);
	}

	@Override
	public List<Payment_historyVO> selectPaymentHistory() {
		return session.selectList(namespace + ".selectPaymentHistory");
	}

	@Override
	public int deletePaymentHistory(int payment_num) {
		return session.delete(namespace + ".deletePaymentHistory", payment_num);
	}

	@Override
	public int updatePaymentHistory(Payment_historyVO phData) {
		return session.update(namespace + ".updatePaymentHistory", phData);
	}

}
