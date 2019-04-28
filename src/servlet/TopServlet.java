package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.db.DBitemBean;
import dao.ItemDao;
import dao.error.DAOException;

@WebServlet("/TopServlet")
public class TopServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	public TopServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setCharacterEncoding(request, response);
		List<DBitemBean> itemBeans = new ArrayList<DBitemBean>();
		List<String> categoryList = new ArrayList<>();

		try {
			ItemDao dao = new ItemDao();
			itemBeans = dao.selectAll();
			request.setAttribute("items", itemBeans);
			categoryList=dao.makeListCategory();
			request.setAttribute("categories", categoryList);
			connectJsp(request, response, "", "top");
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("errormsg", "SQL操作に失敗しました");
			connectJsp(request, response, "exceptionJsp", "error");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
