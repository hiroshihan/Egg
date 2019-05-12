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

	Connection connection;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	public CommonDao() throws DAOException {
		if (connection == null)
			getConnection();
	}

	public String VALUES(List<String> insertItems) {
		StringBuilder sb = new StringBuilder();
		sb.append(" VALUES(");

		for (int i = 0; i < insertItems.size(); i++) {
			sb.append("?");
			sb.append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		return sb.append(")").toString();
	}

	public final String LIKE_BEFORE(String value) {
		StringBuilder sb = new StringBuilder(LIKE).append("'%");
		return sb.append(value).append("'").toString();
	}

	public final String LIKE_AFTER(String value) {
		StringBuilder sb = new StringBuilder(LIKE).append("'");
		return sb.append(value).append("%'").toString();
	}

	public final String LIKE_PART(String value) {
		StringBuilder sb = new StringBuilder(LIKE).append("'%");
		return sb.append(value).append("%'").toString();
	}

	/**
	 * select文の結果取得メソッド
	 *
	 * @param sql
	 *            sql文
	 * @param praceHolder
	 *            プレースホルダの設定
	 * @return List<DBitemBean>
	 * @throws DAOException
	 */
	protected ResultSet executeSelect(String sql, List<Object> praceHolder) throws SQLException {

		statement = connection.prepareStatement(sql);
		if (praceHolder != null) {
			int i = 1;
			for (Object element : praceHolder) {
				if (element instanceof Integer) {
					statement.setInt(i, (Integer) element);
					i++;
				}
				if (element instanceof String) {
					statement.setString(i, (String) element);
					i++;
				}
				if (element instanceof java.sql.Date) {
					statement.setDate(i, (java.sql.Date) element);
					i++;
				}
				if (element instanceof Boolean) {
					statement.setBoolean(i, (Boolean) element);
					i++;
				}
			}
		}
		return statement.executeQuery();
	}

	/**
	 * Update文/Insert文/Delete文の結果取得メソッド
	 *
	 * @param sql
	 *            sql文
	 * @param praceHolder
	 *            プレースホルダの設定
	 * @return List<DBitemBean>
	 * @throws SQLException
	 */
	protected int executeUpdate(String sql, List<Object> praceHolder) throws SQLException {

		statement = connection.prepareStatement(sql);
		if (praceHolder != null) {
			int i = 1;
			for (Object element : praceHolder) {
				if (element instanceof Integer) {
					statement.setInt(i, (Integer) element);
					i++;
				}
				if (element instanceof String) {
					statement.setString(i, (String) element);
					i++;
				}
				if (element instanceof java.sql.Date) {
					statement.setDate(i, (java.sql.Date) element);
					i++;
				}
				if (element instanceof Boolean) {
					statement.setBoolean(i, (Boolean) element);
					i++;
				}
			}
		}
		return statement.executeUpdate();
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

	void close() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
