package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.error.DAOException;

public class CommonDao {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql:egg";
	static final String USER = "egg";
	static final String PASS = "egg1234";

	public static final String SELECT = "SELECT ";
	public static final String FROM = " FROM ";
	public static final String INSERT_INTO = "INSERT INTO ";
	public static final String UPDATE = "UPDATE ";
	public static final String DELETE_FROM = "DELETE FROM";
	public static final String EQUALS = " = ";
	public static final String WHERE = " WHERE ";
	public static final String AND = " AND ";
	public static final String ORDER_BY = " ORDER BY ";
	public static final String DESC = " DESC";
	private static final String LIKE = " LIKE '";

	public String VALUES(List<String> insertItems) {

		StringBuilder sb = new StringBuilder("VALUES(");
		for (String insertItem : insertItems) {
			int i = 1;
			sb.append(insertItem);
			i++;
			if (i == insertItems.size()) {
				break;
			}
			sb.append(", ");

		}
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

	Connection connection;
	PreparedStatement statement = null;

	public CommonDao() throws DAOException {
		if (connection == null)
			getConnection();
	}

	void getConnection() throws DAOException {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。");
		}
	}

	void close() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
