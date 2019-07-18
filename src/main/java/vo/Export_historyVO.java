package vo;

import java.util.Date;

public class Export_historyVO {
	private int export_num;
	private String export_customer_id;
	private String export_customer_name;
	private String export_product_id;
	private String export_product_name;
	private int export_amount;
	private Date export_date;
	private String str_export_date;	
	
	public int getExport_num() {
		return export_num;
	}
	
	public void setExport_num(int export_num) {
		this.export_num = export_num;
	}
	
	public String getExport_customer_id() {
		return export_customer_id;
	}
	
	public void setExport_customer_id(String export_customer_id) {
		this.export_customer_id = export_customer_id;
	}
	
	public String getExport_customer_name() {
		return export_customer_name;
	}

	public void setExport_customer_name(String export_customer_name) {
		this.export_customer_name = export_customer_name;
	}

	public String getExport_product_id() {
		return export_product_id;
	}
	
	public void setExport_product_id(String export_product_id) {
		this.export_product_id = export_product_id;
	}
	
	public String getExport_product_name() {
		return export_product_name;
	}
	
	public void setExport_product_name(String export_product_name) {
		this.export_product_name = export_product_name;
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

	public String getStr_export_date() {
		return str_export_date;
	}

	public void setStr_export_date(String str_export_date) {
		this.str_export_date = str_export_date;
	}
}
