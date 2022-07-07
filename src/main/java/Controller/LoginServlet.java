package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;
import Entity.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String AccountName = request.getParameter("email");
		String pass = request.getParameter("pass");
		String checkingLogin = "errorLogin";
		String msg = "";
		
		
		out.print("AccountName: "+AccountName);
		out.print("pass: "+pass);
		
		if(AccountName.length() == 0 || pass.length() == 0) {
			msg = "Please, input all fileds!";
			session.setAttribute("checkingLogin", checkingLogin);
			session.setAttribute("msg", msg);
			response.sendRedirect("login.jsp");
		}else {
			if("admin@shopcoin".equals(AccountName) && "admin".equals(pass)) {
				response.sendRedirect("adminIndex.jsp");
			}else {
				loginDAO dao = new loginDAO();
				Account isExistAccount = dao.login(AccountName, pass);
				if(isExistAccount == null) {
					msg = "This account is not exists!";
					session.setAttribute("checkingLogin", checkingLogin);
					session.setAttribute("msg", msg);
					response.sendRedirect("login.jsp");
				}else {
					session.setAttribute(AccountName,AccountName);
					response.sendRedirect("index.jsp");
				}
			}
		}
	}

}
