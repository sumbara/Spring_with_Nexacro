package vo;

public class Settle_productVO {
	private int year;
	private int month;
	private String sp_product_id;
	private int carriedOverAmount;
	private int totalImport;
	private int totalExport;
	private int totalAmount;
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
	
	public String getSp_product_id() {
		return sp_product_id;
	}
	
	public void setSp_product_id(String sp_product_id) {
		this.sp_product_id = sp_product_id;
	}
	
	public int getCarriedOverAmount() {
		return carriedOverAmount;
	}
	
	public void setCarriedOverAmount(int carriedOverAmount) {
		this.carriedOverAmount = carriedOverAmount;
	}
	
	public int getTotalImport() {
		return totalImport;
	}
	
	public void setTotalImport(int totalImport) {
		this.totalImport = totalImport;
	}
	
	public int getTotalExport() {
		return totalExport;
	}
	
	public void setTotalExport(int totalExport) {
		this.totalExport = totalExport;
	}
	
	public int getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getSettleState() {
		return settleState;
	}
	
	public void setSettleState(String settleState) {
		this.settleState = settleState;
	}
}