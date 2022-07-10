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
import Entity.AccountDetail;
import Entity.Deposit;

/**
 * Servlet implementation class CreateDepositServlet
 */
@WebServlet("/CreateDeposit")
public class CreateDepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String checking = "notification";
		String smg = "";
		
		
		
		String amountString = request.getParameter("amount");
		float amount = Float.parseFloat(amountString);
		int bankId = Integer.parseInt(request.getParameter("bankID"));
		
		
		
		String AccountName = (String) session.getAttribute("AccountName");
		AccountDetailDAO daoDetail = new AccountDetailDAO();
		AccountDetail detailAccount = daoDetail.getDetailByEmail(AccountName);
		int AccountID = detailAccount.getAccountID();
		
		
		if(amountString.length() == 0 || amountString.length() > 11 ) {
			session.setAttribute("checkingDeposit", checking);
			smg= "Account number have to contain at least 10 digits!";
			session.setAttribute("smgDeposit", smg);
			response.sendRedirect("account.jsp");
		}else {
			session.setAttribute("bankId", bankId);
			session.setAttribute("amount", amount);
			response.sendRedirect("checkout.jsp");
		}
	}

}
