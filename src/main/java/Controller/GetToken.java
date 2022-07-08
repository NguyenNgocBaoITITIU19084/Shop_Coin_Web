package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.forgotDAO;
import Entity.Account;

/**
 * Servlet implementation class GetToken
 */
@WebServlet("/GetToken")
public class GetToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		String smg ="";
		String checking = "error";
		String getToken = (String) request.getParameter("Token");
		
		forgotDAO dao = new forgotDAO();
		Account account = dao.CheckingExistToken(getToken);
		if(account.getAccountName() != null) {
			response.sendRedirect("ChangePassword.jsp");
		}else {
			smg = "Fail to send a link change password to your email";
			session.setAttribute("checkingForgot", checking);
			session.setAttribute("smg", smg);
			response.sendRedirect("forgot.jsp");
		}
	}
}
