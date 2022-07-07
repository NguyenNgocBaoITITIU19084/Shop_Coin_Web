package Entity;

public class AccountDetail extends Account{
	private String userName;
	private String AccountNumber;
	private float Balance;
	private int BankID;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public float getBalance() {
		return Balance;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}
	public int getBankID() {
		return BankID;
	}
	public void setBankID(int bankID) {
		BankID = bankID;
	}
	public AccountDetail(int accountID, String accountName, String password, String userName, String accountNumber,
			float balance, int bankID) {
		super(accountID, accountName, password);
		this.userName = userName;
		AccountNumber = accountNumber;
		Balance = balance;
		BankID = bankID;
	}
	public AccountDetail() {
		
	}
	
	public AccountDetail(String userName) {
		this.userName = userName;
	}
	public AccountDetail(int accountID, String accountName, String password) {
		super(accountID, accountName, password);
	}
	@Override
	public String toString() {
		return "AccountDetail [userName=" + userName + ", AccountNumber=" + AccountNumber + ", Balance=" + Balance
				+ ", BankID=" + BankID + "]";
	}
	
	
}
