package vo;

import java.util.Date;

public class Collect_historyVO {
	private int collect_num;
	private int collectMoney;
	private Date collectDate;
	private String C_History_Customer_id;
	private String C_History_Customer_name;
	private String str_collectDate;
	
	public int getCollect_num() {
		return collect_num;
	}
	
	public void setCollect_num(int collect_num) {
		this.collect_num = collect_num;
	}
	
	public int getCollectMoney() {
		return collectMoney;
	}
	
	public void setCollectMoney(int collectMoney) {
		this.collectMoney = collectMoney;
	}
	
	public Date getCollectDate() {
		return collectDate;
	}
	
	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}
	
	public String getC_History_Customer_id() {
		return C_History_Customer_id;
	}
	
	public void setC_History_Customer_id(String c_History_Customer_id) {
		C_History_Customer_id = c_History_Customer_id;
	}
	
	public String getC_History_Customer_name() {
		return C_History_Customer_name;
	}
	
	public void setC_History_Customer_name(String c_History_Customer_name) {
		C_History_Customer_name = c_History_Customer_name;
	}

	public String getStr_collectDate() {
		return str_collectDate;
	}

	public void setStr_collectDate(String str_collectDate) {
		this.str_collectDate = str_collectDate;
	}
}
