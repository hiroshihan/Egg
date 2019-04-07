package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommonServlet
 */
@WebServlet("/CommonServlet")
public class CommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommonServlet(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void connectJsp(HttpServletRequest request, HttpServletResponse response, String path, String jspName,
			RequestDispatcher rd) throws ServletException, IOException {

		StringBuilder stringBuilder = new StringBuilder("/");
		if (path != null && !path.equals("")) {
			stringBuilder.append(path).append("/");
		}
		String jspLink = stringBuilder.append(jspName).append(".jsp").toString();

		rd = request.getRequestDispatcher(jspLink);
		rd.forward(request, response);
	}
}
