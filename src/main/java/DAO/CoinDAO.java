package DAO;

import java.sql.PreparedStatement;

import Context.ConnectionProvider;

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
}
