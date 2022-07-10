package DAO;

import java.sql.PreparedStatement;

import Context.ConnectionProvider;
import Entity.Account;

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
}
