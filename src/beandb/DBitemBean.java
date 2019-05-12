package beandb;

import bean.CommonBean;

public class DBitemBean extends CommonBean {

	private int db_item_code;
	private String db_item_name;
	private int db_item_price;
	private String db_item_category;
	private String db_item_review;
	private int quantity;
	private int totalprice;
	
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDb_item_code() {
		return db_item_code;
	}
	public void setDb_item_code(int db_item_code) {
		this.db_item_code = db_item_code;
	}
	public String getDb_item_name() {
		return db_item_name;
	}
	public void setDb_item_name(String db_item_name) {
		this.db_item_name = db_item_name;
	}
	public int getDb_item_price() {
		return db_item_price;
	}
	public void setDb_item_price(int db_item_price) {
		this.db_item_price = db_item_price;
	}
	public String getDb_item_category() {
		return db_item_category;
	}
	public void setDb_item_category(String db_item_category) {
		this.db_item_category = db_item_category;
	}
	public String getDb_item_review() {
		return db_item_review;
	}
	public void setDb_item_review(String db_item_review) {
		this.db_item_review = db_item_review;
	}
}
