package Entity;

public class HistoryInfor {
	private String CoinName;
	private double price;
	private double totalPrice;
	private int quantity;
	private String action;
	private int AccountID;
	private String date;
	private String time;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public HistoryInfor(String coinName, double price, double totalPrice, int quantity, String action, int accountID) {
		super();
		CoinName = coinName;
		this.price = price;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.action = action;
		AccountID = accountID;
	}
	public HistoryInfor() {
		super();
	}
	@Override
	public String toString() {
		return "HistoryInfor [CoinName=" + CoinName + ", price=" + price + ", totalPrice=" + totalPrice + ", quantity="
				+ quantity + ", action=" + action + ", AccountID=" + AccountID + "]";
	}
	
}
