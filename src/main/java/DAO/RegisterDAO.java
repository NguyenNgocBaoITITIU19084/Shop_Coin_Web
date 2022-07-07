package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Context.ConnectionProvider;
import Entity.Account;
import Entity.AccountDetail;

public class RegisterDAO {
	public String InsertAccount(Account account){
		String result = "successfully";
		try {
			String query = "insert into Account(AccountName,password) value(?,?);";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, account.getAccountName());
			pst.setString(2, account.getPassword());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	
	public String InsertAccountDetail(AccountDetail accountDetail, int AccountID) {
		String result = "successfully";
		try {
			String query = "insert into AccountDetail(AccountID,userName) value(?,?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			pst.setString(2, accountDetail.getUserName());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public int getAccountID(String email) {
		int id = 0;
		try {
			String query ="select AccountID from Account where AccountName = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getInt("AccountID");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return id; 
	}
}
