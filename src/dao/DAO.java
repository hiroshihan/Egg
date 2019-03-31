package dao;

import bean.CommonBean;

public interface DAO {
	String SELECT = "SELECT ";
	String FROM = "FROM ";
	String INSERT_INTO = "INSERT INTO ";
	String UPDATE = "UPDATE ";
	String DELETE_FROM = "DELETE FROM";
	String WHERE = "WHERE ";

	public Object select(CommonBean bean);

	public Object insertInto(CommonBean bean);
	

}
