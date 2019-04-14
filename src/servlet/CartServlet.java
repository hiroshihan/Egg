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

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import bean.db.DBitemBean;
import dao.ItemDao;

/**
 * Servlet implementation class CartServlet
 */
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
		if(session == null) {
			connectJsp(request, response, null, "cart");
			return;
		}else {
			String wasLogin = (String)session.getAttribute("wasLogin");
			if(wasLogin == null || !wasLogin.equals("true")) {
			connectJsp(request, response, null, "Login");
			return;
			}
		}
		String db_item_code = request.getParameter("db_item_code");
		if(db_item_code == null || db_item_code.length()==0 || db_item_code.equals("1")) {
			gotoPage(request, response, "/cart.jsp");
		}else if(db_item_code.equals("add")) {
			int code = Integer.parseInt(request.getParameter("db_item_code=1"));
			int quanity = Integer.parseInt(request.getParameter("quantity"));
			HttpSession session2 = request.getSession(true);
			DBitemBean item =(DBitemBean)session2.getAttribute("item");
			if(item==null) {
				item = new DBitemBean();
				session2.setAttribute("item", item);
			}
		}
		}
		
				

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String string) {
		// TODO 自動生成されたメソッド・スタブ
		doGet(request, response);
	}
}