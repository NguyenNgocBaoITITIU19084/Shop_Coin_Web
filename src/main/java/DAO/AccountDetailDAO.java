package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;
import Entity.AccountDetail;

public class AccountDetailDAO {
	public AccountDetail getDetailByEmail(String email) {
		AccountDetail detail = null;
		try {
			String query ="select * from Account as a join AccountDetail as d on a.AccountID = d.AccountID where a.AccountName = ? ";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				detail = new AccountDetail();
				detail.setUserName(rs.getString("userName"));
				detail.setBalance(rs.getFloat("Balance"));
				detail.setAccountName(rs.getString("AccountName"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return detail; 
	}
}
