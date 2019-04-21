package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.db.DBitemBean;
import dao.ItemDao;
import dao.error.DAOException;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/CartListServlet")
public class CartListServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	
	HttpSession session = request.getSession(false);
	
	ArrayList<String>cart = (ArrayList<String>)session.getAttribute("products");
	if(cart == null) {
		cart = new ArrayList<String>();
	}
	ItemDao itemDao = null;
	try {
		itemDao = new ItemDao();
	} catch (DAOException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
		throw new IOException();
	}
	ArrayList<DBitemBean>resultList = new ArrayList<>();
	for(String db_item_code : cart) {
		DBitemBean bean = itemDao.getItem(db_item_code);
		resultList.add(bean);
	}
	request.setAttribute("list", resultList);
	
	}

}
