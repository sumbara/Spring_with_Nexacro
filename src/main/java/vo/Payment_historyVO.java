package vo;

import java.util.Date;

public class Payment_historyVO {
	private int payment_num;
	private int payMoney;
	private Date payDate;
	private String p_History_Customer_id;
	private String p_History_Customer_name;
	private String str_payDate;
	
	public int getPayment_num() {
		return payment_num;
	}
	
	public void setPayment_num(int payment_num) {
		this.payment_num = payment_num;
	}
	
	public int getPayMoney() {
		return payMoney;
	}
	
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}
	
	public Date getPayDate() {
		return payDate;
	}
	
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	public String getP_History_Customer_id() {
		return p_History_Customer_id;
	}
	
	public void setP_History_Customer_id(String p_History_Customer_id) {
		this.p_History_Customer_id = p_History_Customer_id;
	}
	
	public String getP_History_Customer_name() {
		return p_History_Customer_name;
	}
	
	public void setP_History_Customer_name(String p_History_Customer_name) {
		this.p_History_Customer_name = p_History_Customer_name;
	}

	public String getStr_payDate() {
		return str_payDate;
	}

	public void setStr_payDate(String str_payDate) {
		this.str_payDate = str_payDate;
	}	
}