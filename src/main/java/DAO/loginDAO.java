package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;
import Entity.Account;


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
}
