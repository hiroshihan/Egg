package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.db.DBuserBean;
import dao.error.DAOException;

public class UserDao extends CommonDao {

	public String TABLE_NAME = "";

	public static final String DB_USER_CODE = "db_user_code";
	public static final String DB_USER_NAME = "db_user_name";
	public static final String DB_USER_POST = "ddb_user_post";
	public static final String DB_USER_EMAIL = "db_user_email";
	public static final String DB_USER_GENDER = "db_user_gender";
	public static final String DB_USER_PASS = "db_user_pass";

	public UserDao() throws DAOException {
		super();
	}

	public List<DBuserBean> addUser() throws DAOException {

		String sql = new StringBuilder(SELECT).append("*").append(FROM).append("ec_user").toString();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<DBuserBean> list = new ArrayList<>();
			DBuserBean dBuserBean = new DBuserBean();
			while (resultSet.next()) {
				dBuserBean.setDb_user_code(resultSet.getInt(DB_USER_CODE));
				dBuserBean.setDb_user_name(resultSet.getString(DB_USER_NAME));
				dBuserBean.setDb_user_post(resultSet.getString(DB_USER_POST));
				dBuserBean.setDb_user_email(resultSet.getString(DB_USER_EMAIL));
				dBuserBean.setDb_user_gender(resultSet.getString(DB_USER_GENDER));
				dBuserBean.setDb_user_pass(resultSet.getString(DB_USER_PASS));
				list.add(dBuserBean);
			}
			return list;

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
	}
	
}
