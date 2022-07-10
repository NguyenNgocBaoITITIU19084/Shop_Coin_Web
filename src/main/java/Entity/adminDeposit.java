package Entity;

public class adminDeposit {
	private int adminDepositID;
	private String adminDepositName;
	private int adminDepositBankID;
	@Override
	public String toString() {
		return "adminDeposit [adminDepositID=" + adminDepositID + ", adminDepositName=" + adminDepositName
				+ ", adminDepositBankID=" + adminDepositBankID + "]";
	}
	public int getAdminDepositID() {
		return adminDepositID;
	}
	public void setAdminDepositID(int adminDepositID) {
		this.adminDepositID = adminDepositID;
	}
	public String getAdminDepositName() {
		return adminDepositName;
	}
	public void setAdminDepositName(String adminDepositName) {
		this.adminDepositName = adminDepositName;
	}
	public int getAdminDepositBankID() {
		return adminDepositBankID;
	}
	public void setAdminDepositBankID(int adminDepositBankID) {
		this.adminDepositBankID = adminDepositBankID;
	}
	public adminDeposit(int adminDepositID, String adminDepositName, int adminDepositBankID) {
		super();
		this.adminDepositID = adminDepositID;
		this.adminDepositName = adminDepositName;
		this.adminDepositBankID = adminDepositBankID;
	}
	public adminDeposit() {
		super();
	}
	
}
