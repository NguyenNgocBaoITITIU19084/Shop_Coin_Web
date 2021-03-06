package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;
import Entity.Account;
import Entity.AccountDetail;


public class loginDAO {
	public Account login(String AccountName,String pass) {
		Account account = null;
		try {
		ConnectionProvider con = new ConnectionProvider();
		String query = "select * from Account where AccountName= ? and password = ?";
		PreparedStatement pst = con.getConnection().prepareStatement(query);
		pst.setString(1, AccountName);
		pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			account = new Account();
			account.setAccountName(rs.getString("AccountName"));
			account.setPassword(rs.getString("password"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	public AccountDetail getUserNameByEmail(String email) {
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
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return detail; 
	}
}
