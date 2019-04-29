package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.db.DBuserBean;
import dao.error.DAOException;

public class UserDao extends CommonDao {

	public static final String TABLE_NAME = "ec_user";

	public static final String DB_USER_CODE = "db_user_code";
	public static final String DB_USER_NAME = "db_user_name";
	public static final String DB_USER_POST = "db_user_post";
	public static final String DB_USER_EMAIL = "db_user_email";
	public static final String DB_USER_GENDER = "db_user_gender";
	public static final String DB_USER_PASS = "db_user_pass";

	public UserDao() throws DAOException {
		super();
	}
	
	public int addUser(String db_user_name, String db_user_post, String db_user_email, String db_user_gender, String db_user_pass) throws DAOException {
		try {
			String sql = "";
			statement = connection.prepareStatement(sql);
			//setStringなどを設定
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
	}

	public void refleshCode() throws DAOException {
		String sqlSelectUserCode = new StringBuilder(SELECT).append(DB_USER_CODE).append(FROM).append(TABLE_NAME)
				.toString();

		try {
			statement = connection.prepareStatement(sqlSelectUserCode);
			resultSet = statement.executeQuery();
			List<Integer> codeList = new ArrayList<>();
			while (resultSet.next()) {
				codeList.add(resultSet.getInt(DB_USER_CODE));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("DBでエラーが発生しました。");
		}

	}
	
	public String getUserPwd(String name) throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append("user").append(WHERE).append("db_user_code").append("=").append("name").toString();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String pwd = resultSet.getString("db_user_pass");
			}
			return pwd;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("DBでエラーが発生しました。");
		}
	}
	
	public int insert(DBuserBean userBean) throws DAOException {

		try {
			String sqlSelectUserCode = new StringBuilder(SELECT).append(DB_USER_CODE).append(FROM).append(TABLE_NAME)
					.toString();
						
			statement = connection.prepareStatement(sqlSelectUserCode);
			resultSet = statement.executeQuery();
			List<Integer> codeList = new ArrayList<>();
			while (resultSet.next()) {
				codeList.add(resultSet.getInt(DB_USER_CODE));
			}
			System.out.println(codeList.size());
			
			int dbUserCount = codeList.size();
 
			List<String> insertItems = new ArrayList<>();
			insertItems.add(DB_USER_CODE);
			insertItems.add(DB_USER_NAME);
			insertItems.add(DB_USER_POST);
			insertItems.	add(DB_USER_EMAIL);
			insertItems.add(DB_USER_GENDER);
			insertItems.add(DB_USER_PASS);

			String sqlInsert = new StringBuilder(INSERT_INTO).append(TABLE_NAME).append(VALUES(insertItems)).toString();
			System.out.println(sqlInsert);
			System.out.println(dbUserCount);


			statement = connection.prepareStatement(sqlInsert);

			int i = 1;

			statement.setInt(i++, dbUserCount + 1);
			statement.setString(i++, userBean.getDb_user_name());
			statement.setString(i++, userBean.getDb_user_post());
			statement.setString(i++, userBean.getDb_user_email());
			statement.setString(i++, userBean.getDb_user_gender());
			statement.setString(i++, userBean.getDb_user_pass());
			int rows = statement.executeUpdate();

			return rows;

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("DBでエラーが発生しました。");
		}

	}

}
