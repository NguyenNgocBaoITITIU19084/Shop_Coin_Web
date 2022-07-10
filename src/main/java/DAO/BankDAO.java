package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import Entity.Account;
import Entity.Bank;


public class BankDAO {
	public String InsertBank(String bankName){
		String result = "successfully";
		try {
			String query = "insert into Bank(BankName) value(?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, bankName);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	
	public List<Bank> getAllBank(){
		List<Bank> brand = new ArrayList<Bank>();
		try {
			String query ="select * from Bank";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Bank row = new Bank();
				row.setBankID(rs.getInt("BankID"));
				row.setBankName(rs.getString("BankName"));
				brand.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return brand;
	}
	public String DeleteBank(int bankID){
		String result = "successfully";
		try {
			String query = "delete from bank where bankID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, bankID);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public String getAdminDepositInfor(int BankID){
		String infor ="";
		try {
			String query ="select * from Bank as b join adminDeposit as a on b.BankID = a.adminDepositBankID where BankID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, BankID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String name = rs.getString("adminDepositName");
				String BankName = rs.getString("BankName");
				infor = name + " - "+BankName;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return infor;
	}
	public int getAdminIDByBankID(int BankID){
		int adminID = 0;
		try {
			String query ="select * from Bank as b join adminDeposit as a on b.BankID = a.adminDepositBankID where BankID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, BankID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				adminID = rs.getInt("adminDepositID");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return adminID;
	}
}

