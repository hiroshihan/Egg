package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.error.DAOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	private String USER = "-";
	private String PASS = "-";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.setCharacterEncoding(request, response);
		String action = request.getParameter("action");

		if (action.equals("login")) {
			String name = request.getParameter("username");
			String pw = request.getParameter("userpassword");

			UserDao dao;
			try {
				dao = new UserDao();

				String dbUser = dao.getUserPwd(name);
				if (USER.equals(name) && PASS.equals(pw)) {
					connectJsp(request, response, null, "top");
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("isLogin", "false");
					connectJsp(request, response, null, "login");
				}
				connectJsp(request, response, null, "login");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
