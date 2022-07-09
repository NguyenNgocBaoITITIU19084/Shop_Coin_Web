package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AccountDetailDAO;
import DAO.loginDAO;
import Entity.Account;
import Entity.AccountDetail;

/**
 * Servlet implementation class UpdatePaymentServlet
 */
@WebServlet("/UpdatePayment")
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String AccountName = (String) session.getAttribute("AccountName");
		AccountDetailDAO daoDetail = new AccountDetailDAO();
		AccountDetail detailAccount = daoDetail.getDetailByEmail(AccountName);
		
		int AccountID = detailAccount.getAccountID();
		int AccountNumber = Integer.parseInt(request.getParameter("account-number"));
		int BankID = Integer.parseInt(request.getParameter("bankID"));
		String smg ="";
		String checking = "notification";
		
		String result = daoDetail.InsertAccountDetail(BankID, AccountNumber, AccountID);
		if("successfully".equals(result)) {
			session.setAttribute("checkingUpdate", checking);
			smg= "Successfully update payment detail!";
			session.setAttribute("smgUpdate", smg);
			response.sendRedirect("account.jsp");
		}else {
			session.setAttribute("checkingUpdate", checking);
			smg= "failed update payment detail!";
			session.setAttribute("smgUpdate", smg);
			response.sendRedirect("account.jsp");
		}
	}

}
