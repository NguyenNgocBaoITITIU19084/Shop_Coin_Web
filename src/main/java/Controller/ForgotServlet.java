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
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

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
		
		if(userName.length() == 0 || email.length() == 0) {
			smg = "Please, input all fields!";
			session.setAttribute("checkingForgot", checking);
			session.setAttribute("smg", smg);
			response.sendRedirect("forgot.jsp");
		}else {
			EmailChecking EmailChecking = new EmailChecking();
			boolean isValidEmail = EmailChecking.validate(email);
			if(isValidEmail == true) {
				forgotDAO dao = new forgotDAO();
				String result = dao.CheckingExistEmail(email, userName);
				if("exist".equals(result)) {
					createJWT create = new createJWT();
					String tokenLink =  create.CreateJWT(userName, email);
					forgotDAO forgotDAO = new forgotDAO();
					String resultToken = forgotDAO.InsertTokenLink(tokenLink,email);
					if("successfully".equals(resultToken)) {
						String sub = "Shop Coin - Change Password Link";
						String text = tokenLink;
						SendEmail send = new SendEmail();
						send.SendEmail(email, userName, sub, text,"changePass");
						
						
						smg = "The link change password is already send to your email, please checking this";
						session.setAttribute("checkingForgot", checking);
						session.setAttribute("smg", smg);
						response.sendRedirect("forgot.jsp");
					}else {
						smg = "Fail to send a link change password to your email";
						session.setAttribute("checkingForgot", checking);
						session.setAttribute("smg", smg);
						response.sendRedirect("forgot.jsp");
					}
				}else {
					smg = "The email or userName is not correct! Please input again!";
					session.setAttribute("checkingForgot", checking);
					session.setAttribute("smg", smg);
					response.sendRedirect("forgot.jsp");
				}
			}else {
				smg = "Please, input valid email";
				session.setAttribute("checkingForgot", checking);
				session.setAttribute("smg", smg);
				response.sendRedirect("forgot.jsp");
			}
		}
	}

}
