package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

import bean.db.DBitemBean;
import bean.db.DBuserBean;
import dao.ItemDao;
import dao.UserDao;
import dao.error.DAOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	private String USER = "-";
	private String PASS = "-";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		String action = request.getParameter("action");
		if (action.equals("login")) {
			String name = request.getParameter("username");
			String pw = request.getParameter("userpassword");
			
			UserDao dao = new UserDao();
			String dbUser = dao.getUserPwd(name);
			if (USER.equals(name) && PASS.equals(pw)) {
				connectJsp(request, response, null, "top");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", "false");
				connectJsp(request, response, null, "login");
			}
			connectJsp(request, response, null, "login");
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
		}

	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page)throws ServletException,
			IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
