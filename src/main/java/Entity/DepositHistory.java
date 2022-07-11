package Entity;

public class DepositHistory {
	private String AccountName;
	private String BankName;
	private double depositUSTD;
	private String adminDepositName;
	private String dateCreated;
	private String timeCreated;
	public String getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public double getDepositUSTD() {
		return depositUSTD;
	}
	public void setDepositUSTD(double depositUSTD) {
		this.depositUSTD = depositUSTD;
	}
	public String getAdminDepositName() {
		return adminDepositName;
	}
	public void setAdminDepositName(String adminDepositName) {
		this.adminDepositName = adminDepositName;
	}
	@Override
	public String toString() {
		return "DepositHistory [AccountName=" + AccountName + ", BankName=" + BankName + ", depositUSTD=" + depositUSTD
				+ ", adminDepositName=" + adminDepositName + "]";
	}
	public DepositHistory(String accountName, String bankName, double depositUSTD, String adminDepositName) {
		super();
		AccountName = accountName;
		BankName = bankName;
		this.depositUSTD = depositUSTD;
		this.adminDepositName = adminDepositName;
	}
	public DepositHistory(String accountName, String bankName, double depositUSTD, String adminDepositName,
			String dateCreated, String timeCreated) {
		super();
		AccountName = accountName;
		BankName = bankName;
		this.depositUSTD = depositUSTD;
		this.adminDepositName = adminDepositName;
		this.dateCreated = dateCreated;
		this.timeCreated = timeCreated;
	}
	public DepositHistory() {
		super();
	}
	
	
}
