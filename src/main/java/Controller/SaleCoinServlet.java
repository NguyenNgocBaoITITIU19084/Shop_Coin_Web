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
import DAO.HistoryDAO;
import DAO.OwnedCoinDAO;
import Entity.AccountDetail;
import Entity.OwnedCoinInfor;

/**
 * Servlet implementation class SaleCoinServlet
 */
@WebServlet("/SaleCoin")
public class SaleCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//get id of account
		String email = (String) session.getAttribute("AccountName");
		AccountDetailDAO detailDAO = new AccountDetailDAO();
		AccountDetail detail = detailDAO.getDetailByEmail(email);
		int AccountID = detail.getAccountID();
		// get coin id 
		String CoinID = request.getParameter("CoinID");
		//get total price by accountId and coinID
		OwnedCoinDAO daoOwnedCoin = new OwnedCoinDAO();
		OwnedCoinInfor Coin = daoOwnedCoin.getCoinByAccount(AccountID, CoinID);
		double totalPrice = Coin.getTotalPrice();
		int quanitySale = Coin.getQuantityOwned();
		// get exist balance of account buy account id 
		AccountDetailDAO daoDetail = new AccountDetailDAO();
		double existbalance = daoDetail.getBalanceExist(AccountID);
		// calculate new balance after sale
		double newBalance = existbalance + totalPrice;
		// update new Balance
		String result = daoDetail.InsertBalanceByAccountID(AccountID, newBalance);
		//delete owned coin by coinId and account id 
		if("successfully".equals(result)) {
			String resultDel = daoOwnedCoin.DeleteOwnedCoin(AccountID, CoinID);
			if("successfully".equals(resultDel)) {
				//add new his
				HistoryDAO daohis = new HistoryDAO();
				daohis.InsertHistoryByAccountID(AccountID, totalPrice, CoinID, quanitySale, "sale");
				response.sendRedirect("index.jsp");
			}
		}
		
	}



}
