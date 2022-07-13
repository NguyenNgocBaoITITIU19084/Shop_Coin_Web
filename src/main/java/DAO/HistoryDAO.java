package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import Entity.Bank;
import Entity.History;
import Entity.HistoryInfor;
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
	public List<HistoryInfor> getAllHistoryByAccountID(int AccountID){
		List<HistoryInfor> listHis = new ArrayList<HistoryInfor>();
		try {
			String query ="select CoinName,h.price,quantity,(quantity*h.price) as total,actionStatus,dayCreated,timeCreated from history as h join coin as c on h.CoinID = c.CoinID where AccountID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				HistoryInfor row = new HistoryInfor();
				row.setCoinName(rs.getString("CoinName"));
				row.setPrice(rs.getDouble("price"));
				row.setQuantity(rs.getInt("quantity"));
				row.setTotalPrice(rs.getDouble("total"));
				row.setAction(rs.getString("actionStatus"));
				row.setDate(rs.getString("dayCreated"));
				row.setTime(rs.getString("timeCreated"));
				listHis.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listHis;
	}
}
