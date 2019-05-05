package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.db.DBuserBean;
import dao.UserDao;
import dao.error.DAOException;

@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

    public InsertUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setCharacterEncoding(request, response);
		try {
			//jsp側からデータを受け取る（request.getParameterを使う）
			DBuserBean userBean=new DBuserBean();
			userBean.setDb_user_name(request.getParameter("name"));
			userBean.setDb_user_pass(request.getParameter("pass"));
			userBean.setDb_user_gender(request.getParameter("gender"));
			userBean.setDb_user_post(request.getParameter("zip11"));
			userBean.setDb_user_email(request.getParameter("mail"));
			UserDao dao =new UserDao();
			//引数にinsertしたいデータを設定する。データはバラでもBeanにまとめるでもどっちでもいいよ
			dao.insert(userBean);
			connectJsp(request, response, "", "complete");
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
