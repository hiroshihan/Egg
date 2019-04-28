package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommonServlet")
public class CommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommonServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setCharacterEncoding(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void setCharacterEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	}

	public void connectJsp(HttpServletRequest request, HttpServletResponse response, String path, String jspName) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StringBuilder stringBuilder = new StringBuilder("/");
		if (path != null && !path.equals("")) {
			stringBuilder.append(path).append("/");
		}
		String jspLink = stringBuilder.append(jspName).append(".jsp").toString();
		
		RequestDispatcher rd = request.getRequestDispatcher(jspLink);
		rd.forward(request, response);
	}
}
