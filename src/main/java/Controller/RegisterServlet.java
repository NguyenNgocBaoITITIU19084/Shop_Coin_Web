package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RegisterDAO;
import Entity.Account;
import Entity.AccountDetail;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String rePass = request.getParameter("rePass");
		
		String checking = "error";
		String message = "";
		
//		checking empty fields
		if(userName.length() == 0 || email.length() == 0 || pass.length() == 0 || rePass.length() == 0) {
			message= "Please, input all fileds!";
			session.setAttribute("checking", checking);
			session.setAttribute("message", message);
			response.sendRedirect("./user/login.jsp");
		}else {
//			checking valid email
			EmailChecking EmailChecking = new EmailChecking();
			boolean isValidEmail = EmailChecking.validate(email);
			if(isValidEmail == true) {
				PasswordChecking PasswordChecking = new PasswordChecking();
				boolean isValidPass = PasswordChecking.validate(pass);
				if(isValidPass == true) {
					// checking pass and rePass matching or not 
					if(pass.equals(rePass)) {
						// admin"admin is admin account
						if(!"admin@admin".equals(email)) {
							Account account = new Account(email,pass);
							AccountDetail AccountDetail = new AccountDetail(userName);
							RegisterDAO dao = new RegisterDAO();
							// insert information into database
								String resultInsertAccount = dao.InsertAccount(account);
								String resultInsertAccountDetail = dao.InsertAccountDetail(AccountDetail);
								
								if("successfully".equals(resultInsertAccount) && "successfully".equals(resultInsertAccountDetail)) {
									message = "Successfully Register Account";
									session.setAttribute("checking", checking);
									session.setAttribute("message", message);
									response.sendRedirect("./user/login.jsp");
								}else {
									message = "This account is already exist!";
									session.setAttribute("checking", checking);
									session.setAttribute("message", message);
									response.sendRedirect("./user/login.jsp");
								}
						}

					}else {
						message = "The password are not matching. please, intput again!";
						session.setAttribute("checking", checking);
						session.setAttribute("message", message);
						response.sendRedirect("./user/login.jsp");
					}
				}else {
					message = "The Password have to contain a digit, a lowercase, a uppercase, and 8 letters long";
					session.setAttribute("checking", checking);
					session.setAttribute("message", message);
					response.sendRedirect("./user/login.jsp");
				}
			}else {
				message = "Please, input valid email";
				session.setAttribute("message", message);
				session.setAttribute("checking", checking);
				response.sendRedirect("./user/login.jsp");
			}
		}
	}

}
