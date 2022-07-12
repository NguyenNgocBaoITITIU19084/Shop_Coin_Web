package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import Entity.History;
import Entity.OwnedCoinInfor;

public class HistoryDAO {
	public String InsertHistoryByAccountID(int AccountID, double price, String CoinID, int quantity, String action){
		String result = "successfully";
		try {
			ConnectionProvider con = new ConnectionProvider();
			String turnOff = "SET FOREIGN_KEY_CHECKS = 0";
			PreparedStatement pstOff = con.getConnection().prepareStatement(turnOff);
			pstOff.executeUpdate();
			String query = "insert into History(AccountID,price,CoinID,quantity,actionStatus) value(?,?,?,?,?)";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			pst.setDouble(2, price);
			pst.setString(3, CoinID);
			pst.setInt(4, quantity);
			pst.setString(5, action);
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
}
