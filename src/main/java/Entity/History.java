package Entity;

public class History {
	private int AccountID;
	private int BankID;
	private int CoinID;
	private double price;
	private int quantity;
	private String actionStatus;
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public int getBankID() {
		return BankID;
	}
	public void setBankID(int bankID) {
		BankID = bankID;
	}
	public int getCoinID() {
		return CoinID;
	}
	public void setCoinID(int coinID) {
		CoinID = coinID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getActionStatus() {
		return actionStatus;
	}
	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}
	@Override
	public String toString() {
		return "History [AccountID=" + AccountID + ", BankID=" + BankID + ", CoinID=" + CoinID + ", price=" + price
				+ ", quantity=" + quantity + ", actionStatus=" + actionStatus + "]";
	}
	public History(int accountID, int bankID, int coinID, double price, int quantity, String actionStatus) {
		super();
		AccountID = accountID;
		BankID = bankID;
		CoinID = coinID;
		this.price = price;
		this.quantity = quantity;
		this.actionStatus = actionStatus;
	}
	public History() {
		super();
	}
	
}
