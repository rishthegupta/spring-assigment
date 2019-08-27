package com.capgemini.bankingApplication.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankaccountdetails")
public class BankAccount {
	@Id
	@Column
	private long accountID;
	@Column
	private String accountHolderName;
	@Column
	private String accountType;
	@Column
	private double accountBalance;
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public BankAccount(long accountID, String accountHolderName, String accountType, double accountBalance) {
		super();
		this.accountID = accountID;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	public BankAccount() {
		super();
	}
	@Override
	public String toString() {
		return "BankAccount [accountID=" + accountID + ", accountHolderName=" + accountHolderName + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + "]";
	}
	

}
