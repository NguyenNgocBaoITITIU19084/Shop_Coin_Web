package Entity;

public class Deposit {
	private int AccountID;
	private int BankID;
	private double depositUSTD;
	private int adminDepositID;
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
	public double getDepositUSTD() {
		return depositUSTD;
	}
	public void setDepositUSTD(double depositUSTD) {
		this.depositUSTD = depositUSTD;
	}
	public int getAdminDepositID() {
		return adminDepositID;
	}
	public void setAdminDepositID(int adminDepositID) {
		this.adminDepositID = adminDepositID;
	}
	@Override
	public String toString() {
		return "Deposit [AccountID=" + AccountID + ", BankID=" + BankID + ", depositUSTD=" + depositUSTD
				+ ", adminDepositID=" + adminDepositID + "]";
	}
	public Deposit(int accountID, int bankID, double depositUSTD, int adminDepositID) {
		super();
		AccountID = accountID;
		BankID = bankID;
		this.depositUSTD = depositUSTD;
		this.adminDepositID = adminDepositID;
	}
	public Deposit() {
		super();
	}
	public Deposit(int accountID, int bankID, double depositUSTD) {
		super();
		AccountID = accountID;
		BankID = bankID;
		this.depositUSTD = depositUSTD;
	}
	
}
