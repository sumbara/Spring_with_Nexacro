package vo;

public class Settle_collectVO {
	private int year;
	private int month;
	private String sc_customer_id;
	private int carriedOverMoney;
	private int totalCollectMoney;
	private int totalNon_collectMoney;
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
	
	public String getSc_customer_id() {
		return sc_customer_id;
	}
	
	public void setSc_customer_id(String sc_customer_id) {
		this.sc_customer_id = sc_customer_id;
	}
	
	public int getCarriedOverMoney() {
		return carriedOverMoney;
	}
	
	public void setCarriedOverMoney(int carriedOverMoney) {
		this.carriedOverMoney = carriedOverMoney;
	}
	
	public int getTotalCollectMoney() {
		return totalCollectMoney;
	}
	
	public void setTotalCollectMoney(int totalCollectMoney) {
		this.totalCollectMoney = totalCollectMoney;
	}
	
	public int getTotalNon_collectMoney() {
		return totalNon_collectMoney;
	}
	
	public void setTotalNon_collectMoney(int totalNon_collectMoney) {
		this.totalNon_collectMoney = totalNon_collectMoney;
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