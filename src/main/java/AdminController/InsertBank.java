package AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BankDAO;

/**
 * Servlet implementation class InsertBank
 */
@WebServlet("/InsertBank")
public class InsertBank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String bank = request.getParameter("bank");
		String smg = "";
		String checking = "errorBank";
		
		if(bank.length() == 0) {
			smg= "Please, input all fileds!";
			session.setAttribute("checkingIBank", checking);
			session.setAttribute("smgIBank", smg);
			response.sendRedirect("adminIndex.jsp");
		}else {
			BankDAO dao = new BankDAO();
			String result = dao.InsertBank(bank);
			if("successfully".equals(result)) {
				smg= "successfully insert new bank!";
				session.setAttribute("checkingIBank", checking);
				session.setAttribute("smgIBank", smg);
				response.sendRedirect("adminIndex.jsp");
			}else {
				smg= "this bank is already exist in database";
				session.setAttribute("checkingIBank", checking);
				session.setAttribute("smgIBank", smg);
				response.sendRedirect("adminIndex.jsp");
			}
		}
	}

}
