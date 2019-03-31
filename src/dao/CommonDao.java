package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.error.DAOException;

public abstract class CommonDao implements DAO {
	static String JDBC_DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql:egg";
	static final String USER = "egg";
	static final String PASS = "egg1234";

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
			// TODO 自動生成された catch ブロック
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
