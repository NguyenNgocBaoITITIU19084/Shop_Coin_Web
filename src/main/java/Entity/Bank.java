package Entity;

public class Bank {
	private int BankID;
	private String BankName;
	public int getBankID() {
		return BankID;
	}
	public void setBankID(int bankID) {
		BankID = bankID;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	@Override
	public String toString() {
		return "Bank [BankID=" + BankID + ", BankName=" + BankName + "]";
	}
	public Bank(int bankID, String bankName) {
		super();
		BankID = bankID;
		BankName = bankName;
	}
	public Bank() {
		super();
	}
	
}
