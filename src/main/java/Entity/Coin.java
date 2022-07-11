package Entity;

public class Coin {
	private int CoinID;
	private String CoinName;
	private double price;
	private double highestPrice;
	private double lowestPrice;
	private double quantityCoin;
	@Override
	public String toString() {
		return "Coin [CoinID=" + CoinID + ", CoinName=" + CoinName + ", price=" + price + ", highestPrice="
				+ highestPrice + ", lowestPrice=" + lowestPrice + ", quantityCoin=" + quantityCoin + "]";
	}
	public int getCoinID() {
		return CoinID;
	}
	public void setCoinID(int coinID) {
		CoinID = coinID;
	}
	public String getCoinName() {
		return CoinName;
	}
	public void setCoinName(String coinName) {
		CoinName = coinName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public double getQuantityCoin() {
		return quantityCoin;
	}
	public void setQuantityCoin(double quantityCoin) {
		this.quantityCoin = quantityCoin;
	}
	public Coin(int coinID, String coinName, double price, double highestPrice, double lowestPrice,
			double quantityCoin) {
		super();
		CoinID = coinID;
		CoinName = coinName;
		this.price = price;
		this.highestPrice = highestPrice;
		this.lowestPrice = lowestPrice;
		this.quantityCoin = quantityCoin;
	}
	public Coin() {
		super();
	}
	
}
