package vo;

import java.util.Date;

public class Import_historyVO {
	private int import_num;
	private String import_customer_id;
	private String import_customer_name;
	private String import_product_id;
	private String import_product_name;
	private int import_amount;
	private Date import_date;
	private String str_import_date;
	
	public int getImport_num() {
		return import_num;
	}
	
	public void setImport_num(int import_num) {
		this.import_num = import_num;
	}
	
	public String getImport_customer_id() {
		return import_customer_id;
	}
	
	public void setImport_customer_id(String import_customer_id) {
		this.import_customer_id = import_customer_id;
	}
	
	public String getImport_customer_name() {
		return import_customer_name;
	}

	public void setImport_customer_name(String import_customer_name) {
		this.import_customer_name = import_customer_name;
	}

	public String getImport_product_id() {
		return import_product_id;
	}
	
	public void setImport_product_id(String import_product_id) {
		this.import_product_id = import_product_id;
	}
	
	public String getImport_product_name() {
		return import_product_name;
	}

	public void setImport_product_name(String import_product_name) {
		this.import_product_name = import_product_name;
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

	public String getStr_import_date() {
		return str_import_date;
	}

	public void setStr_import_date(String str_import_date) {
		this.str_import_date = str_import_date;
	}
}
