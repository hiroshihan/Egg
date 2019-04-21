package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.db.DBitemBean;
import dao.ItemDao;
import dao.error.DAOException;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see CommonServlet#CommonServlet()
	 */
	public TopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		setCharacterEncoding(request, response);
		List<DBitemBean> itemBeans = new ArrayList<DBitemBean>();
		List<String> categoryList = new ArrayList<>();

		try {
			ItemDao dao = new ItemDao();
			itemBeans = dao.selectAll();
			request.setAttribute("items", itemBeans);
			categoryList=dao.makeListCategory();
			request.setAttribute("categories", categoryList);
			connectJsp(request, response, "", "top");
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			request.setAttribute("errormsg", "SQL操作に失敗しました");
			connectJsp(request, response, "exceptionJsp", "error");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

//	public void init() throws ServletException{
//		try {
//				// カテゴリ一覧は最初にアプリケーションスコープへ入れる
//				ItemDao dao = new ItemDao();
//				List<DBitemBean> list = dao.getAllCategories();
//				getServletContext().setAttribute("categories", list);
//		}catch(DAOException e){
//			e.printStackTrace();
//			throw new ServletException();
//		}
//	}
	

}
