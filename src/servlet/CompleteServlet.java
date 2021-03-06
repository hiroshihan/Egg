package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CompleteServlet")
public class CompleteServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try{
			super.setCharacterEncoding(request, response);
			HttpSession session = request.getSession(false);
			String action = request.getParameter("action");
			
			if (action.equals("confirm")) {
				connectJsp(request, response, null, "confirm");		
			}else if (action.equals("end")) {
				session.removeAttribute("cartList");
				connectJsp(request, response, null, "end");
			}
			
		} catch(Exception e) {
			super.connectJsp(request,response,"","login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
