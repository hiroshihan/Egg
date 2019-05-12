package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.db.DBitemBean;
import dao.ItemDao;

@WebServlet("/CartServlet")
public class CartServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			super.setCharacterEncoding(request, response);
			HttpSession session = request.getSession(false);
			String isLogin = (String)session.getAttribute("isLogin");
			@SuppressWarnings("unchecked")
			List<DBitemBean> cartList = (List<DBitemBean>)session.getAttribute("cartList");
			String action = request.getParameter("action");
			
			if(isLogin != null){
				if(isLogin.equals("true")) {
					if(action.equals("show")){
						super.connectJsp(request, response,"","cart");						
					} else {
						String item_code = request.getParameter("item_code");
						String quantity = request.getParameter("quantity");
						ItemDao dao = new ItemDao();
						DBitemBean itembean = dao.getItem(item_code, quantity);
						
						if(cartList == null){
							cartList = new ArrayList<DBitemBean>();
						}
						cartList.add(itembean);
						session.setAttribute("cartList", cartList);
						super.connectJsp(request, response,"","cart");	
					}
				}
			} else {
				super.connectJsp(request,response,"","login");
			}
		} catch(Exception e) {
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}