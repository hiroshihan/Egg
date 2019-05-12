package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.setCharacterEncoding(request, response);
		String action = request.getParameter("action");
		
		
		if (action.equals("login")) {
			
			String name = request.getParameter("username");
			String pw = request.getParameter("userpassword");
			HttpSession session = request.getSession();
			
			try {
				UserDao dao = new UserDao();
			String pawo=dao.getUserPwd(name);
				if (pawo.equals(pw)) {
					session.setAttribute("isLogin", "true");
					connectJsp(request, response, null, "header");
				} else {
					session.setAttribute("isLogin", "false");
					connectJsp(request, response, null, "login");
					
				}
		}
			catch (Exception e) {
				// TODO: handle exception
				connectJsp(request, response, null, "login");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
