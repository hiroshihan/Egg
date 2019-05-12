package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.db.DBitemBean;
import dao.error.DAOException;

public class ItemDao extends CommonDao {

	public String TABLE_NAME = "";

	public static final String DB_ITEM_CODE = "db_item_code";
	public static final String DB_ITEM_NAME = "db_item_name";
	public static final String DB_ITEM_PRICE = "db_item_price";
	public static final String DB_ITEM_CATEGORY = "db_item_category";
	public static final String DB_ITEM_REVIEW = "db_item_review";

	public ItemDao() throws DAOException {
		super();
	}

	public List<DBitemBean> selectAll() throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append("item").toString();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<DBitemBean> list = new ArrayList<>();
			while (resultSet.next()) {
				DBitemBean dBitemBean = new DBitemBean();
				dBitemBean.setDb_item_code(resultSet.getInt(DB_ITEM_CODE));
				dBitemBean.setDb_item_name(resultSet.getString(DB_ITEM_NAME));
				dBitemBean.setDb_item_price(resultSet.getInt(DB_ITEM_PRICE));
				dBitemBean.setDb_item_category(resultSet.getString(DB_ITEM_CATEGORY));
				dBitemBean.setDb_item_review(resultSet.getString(DB_ITEM_REVIEW));
				list.add(dBitemBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
	}

	public List<String> makeListCategory() throws DAOException {
		String sql = new StringBuilder(SELECT).append(DISTINCT).append(DB_ITEM_CATEGORY).append(FROM).append("item").toString();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<String> categoryList = new ArrayList<>();
			while (resultSet.next()) {
				categoryList.add(resultSet.getString(DB_ITEM_CATEGORY));
			}
			return categoryList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");

		}
	}

	 
	public List<DBitemBean> selectName() throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append("item").append(WHERE).append("db_item_name").append(LIKE).append("%").append(DB_ITEM_NAME).append("%").toString();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<DBitemBean> list = new ArrayList<>();
			while (resultSet.next()) {
				DBitemBean dBitemBean = new DBitemBean();
				dBitemBean.setDb_item_code(resultSet.getInt(DB_ITEM_CODE));
				dBitemBean.setDb_item_name(resultSet.getString(DB_ITEM_NAME));
				dBitemBean.setDb_item_price(resultSet.getInt(DB_ITEM_PRICE));
				dBitemBean.setDb_item_category(resultSet.getString(DB_ITEM_CATEGORY));
				dBitemBean.setDb_item_review(resultSet.getString(DB_ITEM_REVIEW));
				list.add(dBitemBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
	}
	 
	public List<DBitemBean> selectCategory(String category) throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append("item").append(WHERE).append("DB_ITEM_CATEGORY").append("=").append("'").append(category).append("'").toString();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<DBitemBean> list = new ArrayList<>();
			while (resultSet.next()) {
				DBitemBean dBitemBean = new DBitemBean();
				dBitemBean.setDb_item_code(resultSet.getInt(DB_ITEM_CODE));
				dBitemBean.setDb_item_name(resultSet.getString(DB_ITEM_NAME));
				dBitemBean.setDb_item_price(resultSet.getInt(DB_ITEM_PRICE));
				dBitemBean.setDb_item_category(resultSet.getString(DB_ITEM_CATEGORY));
				dBitemBean.setDb_item_review(resultSet.getString(DB_ITEM_REVIEW));
				list.add(dBitemBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
	}
	 
	public List<DBitemBean> sortName() throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append("item").append(ORDER_BY).append("db_item_name").toString();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<DBitemBean> list = new ArrayList<>();
			while (resultSet.next()) {
				DBitemBean dBitemBean = new DBitemBean();
				dBitemBean.setDb_item_code(resultSet.getInt(DB_ITEM_CODE));
				dBitemBean.setDb_item_name(resultSet.getString(DB_ITEM_NAME));
				dBitemBean.setDb_item_price(resultSet.getInt(DB_ITEM_PRICE));
				dBitemBean.setDb_item_category(resultSet.getString(DB_ITEM_CATEGORY));
				dBitemBean.setDb_item_review(resultSet.getString(DB_ITEM_REVIEW));
				list.add(dBitemBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
	}
	
	public List<DBitemBean> sortPrice() throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append("item").append(ORDER_BY).append("db_item_price").toString();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<DBitemBean> list = new ArrayList<>();
			while (resultSet.next()) {
				DBitemBean dBitemBean = new DBitemBean();
				dBitemBean.setDb_item_code(resultSet.getInt(DB_ITEM_CODE));
				dBitemBean.setDb_item_name(resultSet.getString(DB_ITEM_NAME));
				dBitemBean.setDb_item_price(resultSet.getInt(DB_ITEM_PRICE));
				dBitemBean.setDb_item_category(resultSet.getString(DB_ITEM_CATEGORY));
				dBitemBean.setDb_item_review(resultSet.getString(DB_ITEM_REVIEW));
				list.add(dBitemBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
		
		
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
	
	public List<DBitemBean> getAllCategories() throws DAOException {
		String sql = new StringBuilder(SELECT).append("*").append(FROM).append("item").toString();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<DBitemBean> list = new ArrayList<>();
			while (resultSet.next()) {
				DBitemBean dBitemBean = new DBitemBean();
				dBitemBean.setDb_item_category(resultSet.getString(DB_ITEM_CATEGORY));
				list.add(dBitemBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}
	}
	
}
