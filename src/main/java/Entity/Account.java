package Entity;

public class Account {
	private int AccountID;
	private String AccountName;
	private String password;
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Account(int accountID, String accountName, String password) {
		super();
		AccountID = accountID;
		AccountName = accountName;
		this.password = password;
	}
	public Account(String accountName, String password) {
		super();
		AccountName = accountName;
		this.password = password;
	}
	public Account() {
		super();
	}
	
	public Account(int accountID, String accountName, String password, String token) {
		super();
		AccountID = accountID;
		AccountName = accountName;
		this.password = password;
		this.token = token;
	}
	@Override
	public String toString() {
		return "Account [AccountID=" + AccountID + ", AccountName=" + AccountName + ", password=" + password + "]";
	}
	
	
	
}
