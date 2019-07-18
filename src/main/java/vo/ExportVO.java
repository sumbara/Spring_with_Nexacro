package vo;

import java.util.Date;

public class ExportVO {
	private String product_id;
	private String product_name;
	private int price;
	private String customer_id;
	private int export_amount;
	private Date export_date;
	
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
	
	public int getExport_amount() {
		return export_amount;
	}
	
	public void setExport_amount(int export_amount) {
		this.export_amount = export_amount;
	}
	
	public Date getExport_date() {
		return export_date;
	}
	
	public void setExport_date(Date export_date) {
		this.export_date = export_date;
	}
}
