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
import DAO.BankDAO;
import DAO.DepositDAO;
import Entity.AccountDetail;

/**
 * Servlet implementation class ConfirmCheckOutServlet
 */
@WebServlet("/ConfirmCheckOut")
public class ConfirmCheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//get bankid
        int bankID = (int) session.getAttribute("bankId");
        // calculate USD to VND
        float amount = (float) session.getAttribute("amount");
        USDtoVND change = new USDtoVND();
        String VNDDeposit = change.USDtoVND(amount);
        
        // get detail of user
		String email = (String) session.getAttribute("AccountName");
		AccountDetailDAO detailDAO = new AccountDetailDAO();
		AccountDetail detail = detailDAO.getDetailByEmail(email);
		int AccountID = detail.getAccountID();
		// get admin Infor
		BankDAO daoBank = new BankDAO();
		String inforAdmin = daoBank.getAdminDepositInfor(bankID);
		int adminID = daoBank.getAdminIDByBankID(bankID);
		
		out.print("adminID:"+adminID);
		// insert infor into database
		DepositDAO daoDeposit = new DepositDAO();
		String resultInsert = daoDeposit.InsertDeposit(AccountID, bankID,amount , adminID);
		
		if("successfully".equals(resultInsert)) {
			double existBalance = detailDAO.getBalanceExist(AccountID);
			double newBalance = amount + existBalance;
			String r = detailDAO.InsertBalanceByAccountID(AccountID, newBalance);
			response.sendRedirect("index.jsp");
		}else {
			String checking = "error";
			String smg = "";
			session.setAttribute("checkingDeposit", checking);
			smg= "Failed to Create Deposit!";
			session.setAttribute("smgDeposit", smg);
			response.sendRedirect("checkout.jsp");
		}
		
	}

}
