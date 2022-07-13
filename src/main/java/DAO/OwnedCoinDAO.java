package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import Entity.OwnedCoinInfor;


public class OwnedCoinDAO {
	public String InsertOwnedCoin(int AccountID,String CoinID,int quantityOwned){
		String result = "successfully";
		try {
			String query = "insert into OwnedCoin(AccountID,CoinID,quantityOwned) value(?,?,?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			pst.setString(2, CoinID);
			pst.setInt(3, quantityOwned);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public int checkingExistCoin(int AccountID, String CoinID) {
		int quantity = 0;
		try {
			String query ="select * from ownedcoin where AccountID = ? and CoinID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			pst.setString(2, CoinID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				quantity = rs.getInt("quantityOwned");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return quantity; 
	}
	public String updateQuantityExistCoin(int quantity,int AccountID, String CoinID){
		String result = "successfully";
		try {
			ConnectionProvider con = new ConnectionProvider();
			String query = "update ownedcoin set quantityOwned = ? where AccountID = ? and CoinID = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, quantity);
			pst.setInt(2, AccountID);
			pst.setString(3, CoinID);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public List<OwnedCoinInfor> getAllCoinByAccount(int AccountID){
		List<OwnedCoinInfor> listCoin = new ArrayList<OwnedCoinInfor>();
		try {
			String query ="select ow.CoinID,CoinName,price,quantityOwned, (quantityOwned*price) as total from OwnedCoin as ow join Coin as c on ow.CoinID = c.CoinID where AccountID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				OwnedCoinInfor row = new OwnedCoinInfor();
				row.setCoinID(rs.getInt("CoinID"));
				row.setCoinName(rs.getString("CoinName"));
				row.setQuantityOwned(rs.getInt("quantityOwned"));
				row.setTotalPrice(rs.getDouble("total"));
				listCoin.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listCoin;
	}
	public OwnedCoinInfor getCoinByAccount(int AccountID, String CoinID){
		OwnedCoinInfor Coin = null;
		try {
			String query ="select ow.CoinID,CoinName,price,quantityOwned, (quantityOwned*price) as total from OwnedCoin as ow join Coin as c on ow.CoinID = c.CoinID where AccountID = ? and ow.coinid = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			pst.setString(2, CoinID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Coin = new OwnedCoinInfor();
				Coin.setCoinID(rs.getInt("CoinID"));
				Coin.setCoinName(rs.getString("CoinName"));
				Coin.setQuantityOwned(rs.getInt("quantityOwned"));
				Coin.setTotalPrice(rs.getDouble("total"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Coin;
	}
	public String DeleteOwnedCoin(int AccountID,String CoinID){
		String result = "successfully";
		try {
			String query = "delete from ownedcoin where AccountID = ? and CoinID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, AccountID);
			pst.setString(2, CoinID);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
}
