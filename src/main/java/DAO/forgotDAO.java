package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;

public class forgotDAO {
	public String CheckingExist(String email,String userName) {
		String result = "";
		try {
			String query ="select a.AccountName, d.userName from Account as a join AccountDetail as d on a.AccountID = d.AccountID where a.AccountName = ? and d.userName = ? ";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, userName);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				result = "exist";
			}

		}catch(Exception e) {
			e.printStackTrace();
			result = "not-exist";
		}
		return result; 
	}
}
