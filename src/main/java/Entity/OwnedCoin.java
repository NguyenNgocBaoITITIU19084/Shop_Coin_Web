package Entity;

public class OwnedCoin {
	private int AccountID;
	private int CoinID;
	private int quantityOwned;
	@Override
	public String toString() {
		return "OwnedCoin [AccountID=" + AccountID + ", CoinID=" + CoinID + ", quantityOwned=" + quantityOwned + "]";
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public int getCoinID() {
		return CoinID;
	}
	public void setCoinID(int coinID) {
		CoinID = coinID;
	}
	public int getQuantityOwned() {
		return quantityOwned;
	}
	public void setQuantityOwned(int quantityOwned) {
		this.quantityOwned = quantityOwned;
	}
	public OwnedCoin(int accountID, int coinID, int quantityOwned) {
		super();
		AccountID = accountID;
		CoinID = coinID;
		this.quantityOwned = quantityOwned;
	}
	public OwnedCoin() {
		super();
	}
	
}
