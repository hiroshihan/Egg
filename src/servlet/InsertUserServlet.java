package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.db.DBuserBean;
import dao.ItemDao;
import dao.UserDao;
import dao.error.DAOException;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see CommonServlet#CommonServlet()
     */
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setCharacterEncoding(request, response);
		try {
			HttpSession session = request.getSession(false);		
			DBuserBean userBean= (DBuserBean) session.getAttribute("userBean");
			
			UserDao dao =new UserDao();
			int result= dao.insert(userBean);

			session.removeAttribute("userBean");
			request.setAttribute("userBean", userBean);
			request.setAttribute("result", result);
			connectJsp(request, response, "", "complete");
			
		} catch (DAOException e) {
			e.printStackTrace();
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
