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
 * Servlet implementation class DeleteBank
 */
@WebServlet("/DeleteBank")
public class DeleteBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		int BankID = Integer.parseInt(request.getParameter("bankID"));
		String smg = "";
		String checking = "errorBank";
		
		BankDAO daoBank = new BankDAO();
		String result = daoBank.DeleteBank(BankID);
		
		
		if("successfully".equals(result)) {
			smg= "successfully delete bank!";
			session.setAttribute("checkingDBank", checking);
			session.setAttribute("smgDBank", smg);
			response.sendRedirect("adminIndex.jsp");
		}else {
			smg= "failed delete bank!";
			session.setAttribute("checkingDBank", checking);
			session.setAttribute("smgDBank", smg);
			response.sendRedirect("adminIndex.jsp");
		}
	}

}
