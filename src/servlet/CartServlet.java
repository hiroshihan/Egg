package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//ログイン済みかどうかチェックする
		//すでに作成済みのセッション領域の取得
		HttpSession session = request.getSession(false);
		String isLogin = request.getParameter("isLogin");
//		if(isLogin != null && isLogin.equals("true")) {
		if("true".equals(isLogin)) {
			return;
		}
		else {
			out.println("<hr><a href='/Egg/Login.jsp'>");
		}
		
		String db_item_Code = request.getParameter("db_item_code");
		
		@SuppressWarnings("unchecked")
		ArrayList<String>cart = (ArrayList<String>)session.getAttribute("products");
		if(cart == null) {
			cart = new ArrayList<String>();
			session.setAttribute("products", cart);
		}
		
		cart.add(db_item_Code);
		
		RequestDispatcher rd = request.getRequestDispatcher("/TopServlet");
		rd.forward(request, response);
		}
	}
