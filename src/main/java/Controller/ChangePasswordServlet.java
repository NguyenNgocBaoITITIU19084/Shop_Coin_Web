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
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String pass = request.getParameter("pass");
		String rePass = request.getParameter("rePass");
		String smg = "";
		String checking = "error";
		
		
		if(pass.length() == 0 || rePass.length() == 0) {
			smg= "Please, input all fileds!";
			session.setAttribute("checkingCP", checking);
			session.setAttribute("smgCP", smg);
			response.sendRedirect("ChangePassword.jsp");
		}else {
			PasswordChecking checkingPass = new PasswordChecking();
			boolean isValidPass = checkingPass.validate(pass);
			if(isValidPass == true) {
				if(pass.equals(rePass)) {
					String accountName = (String) session.getAttribute("validate");
					forgotDAO daoForgot = new forgotDAO();
					String resultChange = daoForgot.ChangePassword(accountName, pass);
					if("successfully".equals(resultChange)) {
						//remove token in database
						daoForgot.DeteleToken(accountName);
						smg= "Successfully change password";
						session.setAttribute("checkingCP", checking);
						session.setAttribute("smgCP", smg);
						response.sendRedirect("ChangePassword.jsp");
						//remove validate session
						request.getSession().removeAttribute("validate");
					}else {
						smg= "Failed change password";
						session.setAttribute("checkingCP", checking);
						session.setAttribute("smgCP", smg);
						response.sendRedirect("ChangePassword.jsp");
					}
					
				}else {
					smg= "The Password is not matching, please input again!";
					session.setAttribute("checkingCP", checking);
					session.setAttribute("smgCP", smg);
					response.sendRedirect("ChangePassword.jsp");
				}
			}else {
				smg= "The Password have to contain a digit, a lowercase, a uppercase, and 8 letters long";
				session.setAttribute("checkingCP", checking);
				session.setAttribute("smgCP", smg);
				response.sendRedirect("ChangePassword.jsp");
			}
		}
	}

}
