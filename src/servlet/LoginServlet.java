package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.setCharacterEncoding(request, response);
		String action = request.getParameter("action");

		try{
			if (action.equals("login")) {
				String name = request.getParameter("username");
				String pw = request.getParameter("userpassword");
			
				HttpSession session = request.getSession();
				UserDao dao = new UserDao();
				String dbpw = dao.getUserPwd(name);
				if (dbpw.equals(pw)) {
					session.setAttribute("isLogin", "true");
					connectJsp(request, response, null, "index");
				} else {
					connectJsp(request, response, null, "login");
				}
			} else if (action.equals("logout")) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
				connectJsp(request, response, null, "index");
			} else if (action.equals("login_view")) {
				connectJsp(request, response, null, "login");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
