package vo;

import java.util.Date;

public class ImportVO {
	private String product_id;
	private String product_name;
	private int price;
	private String customer_id;
	private int import_amount;
	private Date import_date;
	
	public String getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	public int getImport_amount() {
		return import_amount;
	}
	
	public void setImport_amount(int import_amount) {
		this.import_amount = import_amount;
	}
	
	public Date getImport_date() {
		return import_date;
	}
	
	public void setImport_date(Date import_date) {
		this.import_date = import_date;
	}	
}