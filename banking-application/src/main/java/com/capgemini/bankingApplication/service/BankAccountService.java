package com.capgemini.bankingApplication.service;

import java.util.List;

import com.capgemini.bankingApplication.bean.BankAccount;

public interface BankAccountService {

	public List<BankAccount> fetchAllAccounts();
	public BankAccount fetchAccount(long accountID) throws BankAccountNotFoundException;
	public double withdraw(long accountID, double balance) throws LowBalanceException;
	public double deposit(long accountID, double balance);
	public double getBalance(long accountID);
	public boolean fundTransfer(long fromAccount, long toAccount, double balance) throws BankAccountNotFoundException, LowBalanceException;
}
