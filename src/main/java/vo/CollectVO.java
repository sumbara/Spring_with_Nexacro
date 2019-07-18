package vo;

public class CollectVO {
	private String collect_customer_id;
	private int collectmoney;
	private int non_collectmoney;
	
	public String getCollect_customer_id() {
		return collect_customer_id;
	}
	
	public void setCollect_customer_id(String collect_customer_id) {
		this.collect_customer_id = collect_customer_id;
	}
	
	public int getCollectmoney() {
		return collectmoney;
	}
	
	public void setCollectmoney(int collectmoney) {
		this.collectmoney = collectmoney;
	}
	
	public int getNon_collectmoney() {
		return non_collectmoney;
	}
	
	public void setNon_collectmoney(int non_collectmoney) {
		this.non_collectmoney = non_collectmoney;
	}	
}