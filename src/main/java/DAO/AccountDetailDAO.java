package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;
import Entity.Account;
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
				detail.setAccountID(rs.getInt("AccountID"));
				detail.setUserName(rs.getString("userName"));
				detail.setBalance(rs.getFloat("Balance"));
				detail.setAccountName(rs.getString("AccountName"));
				detail.setAccountNumber(rs.getString("AccountNumber"));
				detail.setBankID(rs.getInt("BankID"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return detail; 
	}
	public String InsertAccountDetail(int BankID,int AccountNumber,int AccountID){
		String result = "successfully";
		try {
			ConnectionProvider con = new ConnectionProvider();
			String turnOff = "SET FOREIGN_KEY_CHECKS = 0";
			PreparedStatement pstOff = con.getConnection().prepareStatement(turnOff);
			pstOff.executeUpdate();
			String query = "update AccountDetail set BankID = ?, AccountNumber = ? where AccountID = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, BankID);
			pst.setInt(2, AccountNumber);
			pst.setInt(3, AccountID);
			pst.executeUpdate();
			String turnOn = "SET FOREIGN_KEY_CHECKS = 1";
			PreparedStatement pstOn = con.getConnection().prepareStatement(turnOn);
			pstOn.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public String InsertBalanceByAccountID(int AccountID,double balance){
		String result = "successfully";
		try {
			ConnectionProvider con = new ConnectionProvider();
			String query = "update accountdetail set balance = ? where accountID = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setDouble(1, balance);
			pst.setInt(2, AccountID);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public double getBalanceExist(int AccountID) {
		double balance = 0;
		try {
			String query ="select balance from accountdetail where AccountID = ? ";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				balance = rs.getDouble("balance");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return balance; 
	}
}
