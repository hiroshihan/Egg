package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.error.DAOException;

public class CommonDao {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql:egg";
	static final String USER = "egg";
	static final String PASS = "egg1234";

	public static final String SELECT = "SELECT ";
	public static final String DISTINCT = "DISTINCT ";
	public static final String COUNT = "COUNT ";
	public static final String FROM = " FROM ";
	public static final String INSERT_INTO = "INSERT INTO ";
	public static final String UPDATE = "UPDATE ";
	public static final String DELETE_FROM = "DELETE FROM";
	public static final String EQUALS = " = ";
	public static final String WHERE = " WHERE ";
	public static final String AND = " AND ";
	public static final String ORDER_BY = " ORDER BY ";
	public static final String DESC = " DESC";
	public static final String LIKE = " LIKE ";

	private Connection connection;
	PreparedStatement statement = null;	
	ResultSet resultSet = null;
	
	public String VALUES(List<String> insertItems) {

		StringBuilder sb = new StringBuilder("(");
		for (String insertItem : insertItems) {
			sb.append(insertItem);
			sb.append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(") VALUES(");

		for (int i = 0; i < insertItems.size();i++) {
			sb.append("?");
			sb.append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		return sb.append(")").toString();
	}

	public final String LIKE_BEFORE(String value) {
		StringBuilder sb = new StringBuilder(LIKE).append("%");
		return sb.append(value).append("'").toString();
	}

	public final String LIKE_AFTER(String value) {
		StringBuilder sb = new StringBuilder(LIKE);
		return sb.append(value).append("%'").toString();
	}

	public final String LIKE_PART(String value) {
		StringBuilder sb = new StringBuilder(LIKE).append("%");
		return sb.append(value).append("%'").toString();
	}



	public CommonDao() throws DAOException {
		if (connection == null)
			getConnection();
	}

	private void getConnection() throws DAOException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
