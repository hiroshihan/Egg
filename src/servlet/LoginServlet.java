package servlet;

import java.io.IOException;

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
//public class LoginServlet extends CommonServlet {
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	

	public LoginServlet(){
		//super(request);
		super();
	}
	
	private String USER = "-";
	private String PASS = "-";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTf-8");
		
		String action = request.getParameter("action");
		if(action.equals("login")) {
			String name = request.getParameter("username");
			String pw = request.getParameter("userpassword");
			
			if(name.equals(USER)&& pw.equals(PASS)) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", "true");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin","false");
			}
		} else if(action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
			}
		}
	}
				
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
