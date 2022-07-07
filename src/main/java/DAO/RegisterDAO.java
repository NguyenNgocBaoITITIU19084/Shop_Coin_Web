package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Context.ConnectionProvider;
import Entity.Account;
import Entity.AccountDetail;

public class RegisterDAO {
	public String InsertAccount(Account account) throws ClassNotFoundException, SQLException {
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
	
	public String InsertAccountDetail(AccountDetail accountDetail) throws ClassNotFoundException, SQLException {
		String result = "successfully";
		try {
			String query = "insert into AccountDetail(userName) value(?);";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, accountDetail.getUserName());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
}
