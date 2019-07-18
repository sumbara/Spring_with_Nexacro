package vo;

public class Settle_paymentVO {
	private int year;
	private int month;
	private String sp_customer_id;
	private int carriedOverMoney;
	private int totalPayMoney;
	private int totalNon_paymoney;
	private int totalMoney;
	private String settleState;
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String getSp_customer_id() {
		return sp_customer_id;
	}
	
	public void setSp_customer_id(String sp_customer_id) {
		this.sp_customer_id = sp_customer_id;
	}
	
	public int getCarriedOverMoney() {
		return carriedOverMoney;
	}
	
	public void setCarriedOverMoney(int carriedOverMoney) {
		this.carriedOverMoney = carriedOverMoney;
	}
	
	public int getTotalPayMoney() {
		return totalPayMoney;
	}
	
	public void setTotalPayMoney(int totalPayMoney) {
		this.totalPayMoney = totalPayMoney;
	}
	
	public int getTotalNon_paymoney() {
		return totalNon_paymoney;
	}
	
	public void setTotalNon_paymoney(int totalNon_paymoney) {
		this.totalNon_paymoney = totalNon_paymoney;
	}
	
	public int getTotalMoney() {
		return totalMoney;
	}
	
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public String getSettleState() {
		return settleState;
	}
	
	public void setSettleState(String settleState) {
		this.settleState = settleState;
	}
}
