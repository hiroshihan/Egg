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

	public Object insert(CommonBean bean);
	
	public int update(CommonBean bean);
	
	public int delete(CommonBean bean);
	
}
