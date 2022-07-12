package Entity;

public class OwnedCoinInfor {
	private int CoinID;
	public int getCoinID() {
		return CoinID;
	}
	public void setCoinID(int coinID) {
		CoinID = coinID;
	}
	private String CoinName;
	private int quantityOwned;
	private double totalPrice;
	@Override
	public String toString() {
		return "OwnedCoinInfor [CoinName=" + CoinName + ", quantityOwned=" + quantityOwned + ", totalPrice="
				+ totalPrice + "]";
	}
	public OwnedCoinInfor(String coinName, int quantityOwned, double totalPrice) {
		super();
		CoinName = coinName;
		this.quantityOwned = quantityOwned;
		this.totalPrice = totalPrice;
	}
	public OwnedCoinInfor() {
		super();
	}
	public String getCoinName() {
		return CoinName;
	}
	public void setCoinName(String coinName) {
		CoinName = coinName;
	}
	public int getQuantityOwned() {
		return quantityOwned;
	}
	public void setQuantityOwned(int quantityOwned) {
		this.quantityOwned = quantityOwned;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
