package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	private String USER = "-";
	private String PASS = "-";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.setCharacterEncoding(request, response);
		String action = request.getParameter("action");
		
		if (action.equals("login")) {
			String name = request.getParameter("username");
			String pw = request.getParameter("userpassword");
			if (USER.equals(name) && PASS.equals(pw)) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", "true");
			}
			connectJsp(request, response, null, "login");
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
