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

/**
 * Servlet implementation class ConfirmBuyCoinServlet
 */
@WebServlet("/ConfirmBuyCoin")
public class ConfirmBuyCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("coinID");
//		int CoinID = Integer.getInteger(id);
		String name = request.getParameter("coinName");
		String p = request.getParameter("price");
		double price = Double.parseDouble(p);
		String quan = request.getParameter("quantity");
		int quantity = Integer.parseInt(quan);
		String smg = "";
		String checkingConfirm = "error";
	
		
		String AccountName = (String) session.getAttribute("AccountName");
		AccountDetailDAO daoDetail = new AccountDetailDAO();
		AccountDetail user = daoDetail.getDetailByEmail(AccountName);
		int userID = user.getAccountID();
		double availableBalance = daoDetail.getBalanceExist(userID);
		
		if(availableBalance == 0) {
			request.setAttribute("CoinID", id);
			smg = "your available balance is not enough, please create deposit!";
			session.setAttribute("checkingConfirm", checkingConfirm);
			session.setAttribute("msgConfirm", smg);
			request.getRequestDispatcher("cartpage.jsp").forward(request, response);
		}else {
			double total = price*quantity;
			double remain = availableBalance - price*quantity;
			if(remain < 0) {
				request.setAttribute("CoinID", id);
				smg = "your available balance is not enough, please create deposit!";
				session.setAttribute("checkingConfirm", checkingConfirm);
				session.setAttribute("msgConfirm", smg);
				request.getRequestDispatcher("cartpage.jsp").forward(request, response);
			}else {
				String resultOwnedCoin = "";
				OwnedCoinDAO daoOwnedCoin = new OwnedCoinDAO();
				// checking exist coin by account id
				int quantityExistChecking = daoOwnedCoin.checkingExistCoin(userID, id);
				if(quantityExistChecking == 0) {
					String result = daoDetail.InsertBalanceByAccountID(userID, remain);
					resultOwnedCoin =  daoOwnedCoin.InsertOwnedCoin(userID, id, quantity);
					HistoryDAO daoHis = new HistoryDAO();
					String resultHis = daoHis.InsertHistoryByAccountID(userID, total, id, quantity, "buy");
				}else {
					HistoryDAO daoHis = new HistoryDAO();
					String resultHis = daoHis.InsertHistoryByAccountID(userID, total, id, quantity, "buy");
					quantity = quantity + quantityExistChecking;
					String result = daoDetail.InsertBalanceByAccountID(userID, remain);
					resultOwnedCoin =  daoOwnedCoin.updateQuantityExistCoin(quantity, userID, id);
				}
				// add into history
				
				request.getSession().removeAttribute("CoinID");
				response.sendRedirect("index.jsp");
			}
		}
		
	}

}
