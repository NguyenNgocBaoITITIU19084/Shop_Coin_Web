package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import Entity.Coin;


public class CoinDAO {
	public String InsertCoinInfor(String coinName,String price){
		String result = "successfully";
		try {
			ConnectionProvider con = new ConnectionProvider();
			String query = "update coin set price = ? where coinName = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, price);
			pst.setString(2, coinName);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	public List<Coin> getAllCoin(){
		List<Coin> coin = new ArrayList<Coin>();
		try {
			String query = "select * from coin";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Coin row = new Coin();
				row.setCoinID(rs.getInt("CoinID"));
				row.setCoinName(rs.getString("CoinName"));
				row.setPrice(rs.getDouble("price"));
				row.setHighestPrice(rs.getDouble("highestPrice"));
				row.setLowestPrice(rs.getDouble("lowestPrice"));
				row.setQuantityCoin(rs.getDouble("quantityCoin"));
				coin.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return coin;
	}
	public Coin getInforCoinByID(int CoinID){
		Coin coin = null;
		try {
			String query = "select * from coin where CoinID = ?";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setInt(1, CoinID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				coin = new Coin();
				coin.setCoinID(rs.getInt("CoinID"));
				coin.setCoinName(rs.getString("CoinName"));
				coin.setPrice(rs.getDouble("price"));
				coin.setQuantityCoin(rs.getDouble("quantityCoin"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return coin;
	}
}
