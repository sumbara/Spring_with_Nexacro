package vo;

public class PCCustomerVO {
	private String customer_id;
	private String customer_name;
	private int money;
	private int non_money;
	
	public String getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getNon_money() {
		return non_money;
	}
	
	public void setNon_money(int non_money) {
		this.non_money = non_money;
	}
}
