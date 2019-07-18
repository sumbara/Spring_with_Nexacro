package dao;

import java.util.List;

import vo.PCCustomerVO;
import vo.PaymentVO;
import vo.Payment_historyVO;

public interface PaymentDAO {
	public PaymentVO selectPaymentData(String customer_id);
	public int updatePayment(PaymentVO payData);
	public int insertPayment(PaymentVO payData);
	public List<PCCustomerVO> selectPaymentCustomer();
	public int insertPaymentHistory(Payment_historyVO phData);
	public List<Payment_historyVO> selectPaymentHistory();
	public int deletePaymentHistory(int payment_num);
	public int updatePaymentHistory(Payment_historyVO phData);
}
