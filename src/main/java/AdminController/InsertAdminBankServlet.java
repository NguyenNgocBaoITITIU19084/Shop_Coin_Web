package AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DepositDAO;
import Entity.adminDeposit;

/**
 * Servlet implementation class InsertAdminBankServlet
 */
@WebServlet("/InsertAdminBank")
public class InsertAdminBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String BankID = request.getParameter("bankID");
		String AdminName = request.getParameter("adminName");
		String checking = "error";
		String msg = "";
		
		if(AdminName.length() == 0) {
			msg= "Please, input all fileds!";
			session.setAttribute("checkingABank", checking);
			session.setAttribute("smgABank", msg);
			response.sendRedirect("adminIndex.jsp");
		}else {
			DepositDAO daoDeposit = new DepositDAO();
			String result = daoDeposit.InsertDepositAdmin(AdminName, BankID);
			if("successfully".equals(result)) {
				
				msg= "Successfully insert admin bank!";
				session.setAttribute("checkingABank", checking);
				session.setAttribute("smgABank", msg);
				response.sendRedirect("adminIndex.jsp");
			}else {
				msg= "failed to insert admin bank";
				session.setAttribute("checkingABank", checking);
				session.setAttribute("smgABank", msg);
				response.sendRedirect("adminIndex.jsp");
			}
			
		}
	}

}
