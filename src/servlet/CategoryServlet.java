package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beandb.DBitemBean;
import dao.ItemDao;
import daoerror.DAOException;


@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			
			if (action == null || action.length() == 0 || action.equals("top")) {
				gotoPage(request, response,"/top.jsp");
			}else if(action.equals("list")){
				ItemDao dao = new ItemDao();
				List<String> categoryList = dao.makeListCategory();
				request.setAttribute("categories", categoryList);
				
				String category = request.getParameter("code");
				List<DBitemBean> list = dao.selectCategory(category);
				request.setAttribute("items", list);
				gotoPage(request, response,"/category.jsp");
			}else{
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request,response,"/errInternal.jsp");
			}
		}catch(DAOException e){
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
		
	}
	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}