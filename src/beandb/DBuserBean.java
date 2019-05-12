package beandb;

import bean.CommonBean;

public class DBuserBean extends CommonBean {
	private int db_user_code;
	private String db_user_name; 
	private String db_user_post;
	private String db_user_email;
	private String db_user_gender;
	private String db_user_pass;
	
	public DBuserBean() {
		super();
	}
	
	public DBuserBean(int db_user_code, String db_user_name, String db_user_post, String db_user_email,
			String db_user_gender, String db_user_pass) {
		super();
		this.db_user_code = db_user_code;
		this.db_user_name = db_user_name;
		this.db_user_post = db_user_post;
		this.db_user_email = db_user_email;
		this.db_user_gender = db_user_gender;
		this.db_user_pass = db_user_pass;
	}

	public int getDb_user_code() {
		return db_user_code;
	}
	public void setDb_user_code(int db_user_code) {
		this.db_user_code = db_user_code;
	}
	public String getDb_user_name() {
		return db_user_name;
	}
	public void setDb_user_name(String db_user_name) {
		this.db_user_name = db_user_name;
	}
	public String getDb_user_post() {
		return db_user_post;
	}
	public void setDb_user_post(String db_user_post) {
		this.db_user_post = db_user_post;
	}
	public String getDb_user_email() {
		return db_user_email;
	}
	public void setDb_user_email(String db_user_email) {
		this.db_user_email = db_user_email;
	}
	public String getDb_user_gender() {
		return db_user_gender;
	}
	public void setDb_user_gender(String db_user_gender) {
		this.db_user_gender = db_user_gender;
	}
	public String getDb_user_pass() {
		return db_user_pass;
	}
	public void setDb_user_pass(String db_user_pass) {
		this.db_user_pass = db_user_pass;
	}
}
