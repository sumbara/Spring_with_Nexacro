package vo;

public class ExtractSettleVO {
	private String customer_id;
	private String product_id;
	private String ex_yearMonth;
	private String now_yearMonth;
	
	public String getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	public String getEx_yearMonth() {
		return ex_yearMonth;
	}
	
	public void setEx_yearMonth(String ex_yearMonth) {
		this.ex_yearMonth = ex_yearMonth;
	}
	
	public String getNow_yearMonth() {
		return now_yearMonth;
	}
	
	public void setNow_yearMonth(String now_yearMonth) {
		this.now_yearMonth = now_yearMonth;
	}
}
