package vo;

public class PaymentVO {
	private String payment_customer_id;
	private int paymoney;
	private int non_paymoney;
	
	public String getPayment_customer_id() {
		return payment_customer_id;
	}

	public void setPayment_customer_id(String payment_customer_id) {
		this.payment_customer_id = payment_customer_id;
	}

	public int getPaymoney() {
		return paymoney;
	}
	
	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}
	
	public int getNon_paymoney() {
		return non_paymoney;
	}
	
	public void setNon_paymoney(int non_paymoney) {
		this.non_paymoney = non_paymoney;
	}
}
