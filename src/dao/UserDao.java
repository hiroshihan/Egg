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

	/**
	 * select文実装の基本メソッド
	 *
	 * @param sql
	 *            sql文
	 * @param praceHolder
	 *            プレースホルダの設定
	 * @return List<DBitemBean>
	 * @throws DAOException
	 */
	private List<DBuserBean> select(String sql, List<Object> praceHolder) throws DAOException {
		try {
			resultSet = executeSelect(sql, praceHolder);
			List<DBuserBean> list = new ArrayList<>();
			while (resultSet.next()) {
				DBuserBean userBean = new DBuserBean(resultSet.getInt(DB_USER_CODE),
						resultSet.getString(DB_USER_NAME), resultSet.getString(DB_USER_POST),
						resultSet.getString(DB_USER_EMAIL), resultSet.getString(DB_USER_GENDER),
						resultSet.getString(DB_USER_PASS));
				list.add(userBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	/**
	 * @param sql
	 *            sql文
	 * @param column
	 *            抽出するカラム名
	 * @param praceHolder
	 *            プレースホルダ
	 * @return List<Object>
	 * @throws DAOException
	 */
	private List<Object> select(String sql, String column, List<Object> praceHolder) throws DAOException {
		try {
			resultSet = executeSelect(sql, praceHolder);
			List<Object> list = new ArrayList<>();
			while (resultSet.next()) {
				if (DB_USER_CODE.equals(column)) {
					Integer value = resultSet.getInt(column);
					list.add(value);
				} else {
					String value = resultSet.getString(column);
					list.add(value);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public int insert(DBuserBean userBean) throws DAOException {

		try {
			String sqlSelectUserCode = new StringBuilder(SELECT).append(DB_USER_CODE).append(FROM).append(TABLE_NAME).toString();
			List<Object> codeList = select(sqlSelectUserCode, DB_USER_CODE, null);
			int dbUserCount = codeList.size();

			List<String> insertItems = new ArrayList<>();
			insertItems.add(DB_USER_CODE);
			insertItems.add(DB_USER_NAME);
			insertItems.add(DB_USER_POST);
			insertItems.add(DB_USER_EMAIL);
			insertItems.add(DB_USER_GENDER);
			insertItems.add(DB_USER_PASS);
			String sqlInsert = new StringBuilder(INSERT_INTO).append(TABLE_NAME).append(VALUES(insertItems)).toString();
			
			List<Object> praceHolder = new ArrayList<>();
			praceHolder.add(dbUserCount+1);
			praceHolder.add(userBean.getDb_user_name());
			praceHolder.add(userBean.getDb_user_post());
			praceHolder.add(userBean.getDb_user_email());
			praceHolder.add(userBean.getDb_user_gender());
			praceHolder.add(userBean.getDb_user_pass());

			return executeUpdate(sqlInsert, praceHolder);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("DBでエラーが発生しました。");
		}

	}

	public String getUserPwd(String name) throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append(TABLE_NAME).append(WHERE)
				.append(DB_USER_CODE).append("=?").toString();

		List<Object> praceHolder = new ArrayList<>();
		praceHolder.add(name);
		List<DBuserBean> userList = select(sql, praceHolder);

		return userList.get(0).getDb_user_pass();
	}

}
