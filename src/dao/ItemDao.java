package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.db.DBitemBean;
import dao.error.DAOException;

public class ItemDao extends CommonDao {

	public static final String TABLE_NAME = "item";
	public static final String DB_ITEM_CODE = "db_item_code";
	public static final String DB_ITEM_NAME = "db_item_name";
	public static final String DB_ITEM_PRICE = "db_item_price";
	public static final String DB_ITEM_CATEGORY = "db_item_category";
	public static final String DB_ITEM_REVIEW = "db_item_review";

	public ItemDao() throws DAOException {
		super();
	}

	/**
	 * select文実装の基本メソッド
	 *
	 * @param sql  sql文
	 * @param praceHolder プレースホルダの設定
	 * @return List<DBitemBean>
	 * @throws DAOException
	 */
	private List<DBitemBean> select(String sql, List<Object> praceHolder) throws DAOException {
		try {
			resultSet = executeSelect(sql, praceHolder);
			List<DBitemBean> list = new ArrayList<>();
			while (resultSet.next()) {
				DBitemBean dBitemBean = new DBitemBean();
				list.add(dBitemBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}


	/**
	 * @param sql sql文
	 * @param column 抽出するカラム名
	 * @param praceHolder プレースホルダ
	 * @return List<Object>
	 * @throws DAOException
	 */
	private List<Object> select(String sql,String column, List<Object> praceHolder) throws DAOException {
		try {
			resultSet = executeSelect(sql, praceHolder);
			List<Object> list = new ArrayList<>();
			while (resultSet.next()) {
				if(DB_ITEM_CODE.equals(column)||DB_ITEM_PRICE.equals(column)){
					Integer value =	resultSet.getInt(column);
					list.add(value);
				}else {
					String value =resultSet.getString(column);
					list.add(value);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public List<DBitemBean> selectAll() throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append(TABLE_NAME).toString();
		return select(sql, null);
	}

	public List<DBitemBean> selectName(String name) throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append(TABLE_NAME).append(WHERE)
				.append(DB_ITEM_NAME).append(LIKE_PART(name)).toString();
		return select(sql, null);
	}

	public List<String> makeListCategory() throws DAOException {
		String sql = new StringBuilder(SELECT).append(DISTINCT).append(DB_ITEM_CATEGORY).append(FROM).append(TABLE_NAME)
				.toString();
		List<String> categoryList = new ArrayList<>();
		for (Object itemCategory : select(sql, DB_ITEM_CATEGORY, null)) {
			categoryList.add((String) itemCategory);
		}
		return categoryList;
	}

	public List<DBitemBean> selectCategory(String category) throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append(TABLE_NAME).append(WHERE)
				.append(DB_ITEM_CATEGORY).append("=?").toString();
		List<Object> praceHolder = new ArrayList<>();
		praceHolder.add(category);
		return select(sql, praceHolder);
	}

	public List<DBitemBean> sortName() throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append(TABLE_NAME).append(ORDER_BY)
				.append(DB_ITEM_NAME).toString();
		return select(sql, null);
	}

	public List<DBitemBean> sortPrice() throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append(TABLE_NAME).append(ORDER_BY)
				.append(DB_ITEM_PRICE).toString();
		return select(sql, null);
	}

	public DBitemBean getItem(String db_item_code, String quantity) throws DAOException {
		try {
			String sql =  "SELECT * FROM item WHERE db_item_code = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(db_item_code));
			resultSet = statement.executeQuery();
			DBitemBean dBitemBean = new DBitemBean();
			while (resultSet.next()) {
				dBitemBean.setDb_item_code(resultSet.getInt(DB_ITEM_CODE));
				dBitemBean.setDb_item_name(resultSet.getString(DB_ITEM_NAME));
				dBitemBean.setDb_item_price(resultSet.getInt(DB_ITEM_PRICE));
				dBitemBean.setDb_item_category(resultSet.getString(DB_ITEM_CATEGORY));
				dBitemBean.setDb_item_review(resultSet.getString(DB_ITEM_REVIEW));
				dBitemBean.setQuantity(Integer.parseInt(quantity));
				dBitemBean.setTotalprice(resultSet.getInt(DB_ITEM_PRICE) * Integer.parseInt(quantity));
			}
			return dBitemBean;
		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
	}
}