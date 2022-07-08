package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.ConnectionProvider;
import Entity.Account;

public class forgotDAO {
	public String CheckingExistEmail(String email,String userName) {
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
	public String InsertTokenLink(String tokenLink,String email){
		String result = "successfully";
		try {
			String query = "update Account set token = ? where AccountName = ? ";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, tokenLink);
			pst.setString(2, email);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public Account CheckingExistToken(String token) {
		Account userName = null;
		try {
			String query ="select AccountName from Account where token = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, token);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				userName = new Account();
				userName.setAccountName(rs.getString("AccountName"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return userName; 
	}
	public String ChangePassword(String email,String pass){
		String result = "successfully";
		try {
			String query = "update Account set password = ? where AccountName = ? ";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, pass);
			pst.setString(2, email);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public String DeteleToken(String email){
		String result = "successfully";
		String empty = "";
		try {
			String query = "update Account set token = ? where AccountName = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, empty);
			pst.setString(2, email);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
}
