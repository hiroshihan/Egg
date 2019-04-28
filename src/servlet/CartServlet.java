package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.setCharacterEncoding(request, response);
		HttpSession session = request.getSession(false);
		String isLogin = (String)session.getAttribute("isLogin");
		
		if(isLogin.equals("true")) {
			super.connectJsp(request,response,"","cart");
		} else {
			super.connectJsp(request,response,"","login");
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}