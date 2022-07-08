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

/**
 * Servlet implementation class ForgotServlet
 */
@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		
		String checking = "error";
		String smg = "";
		
		
		out.print("userName: "+userName);
		out.print("Email: "+email);
		
		if(userName.length() == 0 || email.length() == 0) {
			smg = "Please, input all fields!";
			session.setAttribute("checking", checking);
			session.setAttribute("smg", smg);
			response.sendRedirect("forgot.jsp");
		}else {
			EmailChecking EmailChecking = new EmailChecking();
			boolean isValidEmail = EmailChecking.validate(email);
			if(isValidEmail == true) {
				forgotDAO dao = new forgotDAO();
				String result = dao.CheckingExist(email, userName);
				if("exist".equals(result)) {
					String sub = "Shop Coin Test 2 - Change Password Link";
					String text = "Here is the link to Change Password";
					SendEmail send = new SendEmail();
					send.SendEmail(email, userName, sub, text);
				}else {
					smg = "The email or userName is not correct! Please input again!";
					session.setAttribute("checking", checking);
					session.setAttribute("smg", smg);
					response.sendRedirect("forgot.jsp");
				}
			}else {
				smg = "Please, input valid email";
				session.setAttribute("checking", checking);
				session.setAttribute("smg", smg);
				response.sendRedirect("forgot.jsp");
			}
		}
	}

}
