package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import Entity.Account;
import Entity.Deposit;
import Entity.DepositHistory;


public class DepositDAO {
	public String InsertDeposit(int AccountID,int bankID, double depositUSTD, int adminDepositID){
		String result = "successfully";
		try {
			String query = "insert into deposit(AccountID,BankID,depositUSTD,adminDepositID) value(?,?,?,?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			pst.setInt(2, bankID);
			pst.setDouble(3, depositUSTD);
			pst.setInt(4, adminDepositID);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public List<DepositHistory> getDepositHistory(String email){
		List<DepositHistory> depositHis = new ArrayList<DepositHistory>();
		try {
			String query ="select AccountName,BankName,depositUSTD,adminDepositName,dayCreated,timeCreated from deposit as d join Account as a on d.AccountID = a.AccountID join bank as b on d.BankID = b.BankID join admindeposit as ad on d.adminDepositID = ad.adminDepositID where AccountName = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				DepositHistory row = new DepositHistory();
				row.setAccountName(rs.getString("AccountName"));
				row.setBankName(rs.getString("BankName"));
				row.setDepositUSTD(rs.getDouble("depositUSTD"));
				row.setAdminDepositName(rs.getString("adminDepositName"));
				row.setDateCreated(rs.getString("dayCreated"));
				row.setTimeCreated(rs.getString("timeCreated"));
				depositHis.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return depositHis;
	}
}
