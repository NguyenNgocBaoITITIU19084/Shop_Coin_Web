package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("AccountName");
		request.getSession().removeAttribute("userName");
		request.getSession().removeAttribute("Balance");
		request.getSession().removeAttribute("DepositVND");
		request.getSession().removeAttribute("amount");
		response.sendRedirect("login.jsp");
	}


}
