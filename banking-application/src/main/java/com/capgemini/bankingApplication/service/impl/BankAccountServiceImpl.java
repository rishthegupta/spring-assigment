package com.capgemini.bankingApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankingApplication.bean.BankAccount;
import com.capgemini.bankingApplication.repository.BankAccountRepository;
import com.capgemini.bankingApplication.service.BankAccountNotFoundException;
import com.capgemini.bankingApplication.service.BankAccountService;
import com.capgemini.bankingApplication.service.LowBalanceException;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired 
	private BankAccountRepository bankAccountRepository;
	
	public List<BankAccount> fetchAllAccounts() {
		// TODO Auto-generated method stub
		return bankAccountRepository.findAll();
	}

	public BankAccount fetchAccount(long accountID) throws BankAccountNotFoundException {
		// TODO Auto-generated method stub
BankAccount result=bankAccountRepository.getOne(accountID);
		
		if(result==null)
		{
			throw new BankAccountNotFoundException("Bank Account with"+accountID+" does not exist");
		}
		return result;
	}

	public double withdraw(long accountID, double balance) throws LowBalanceException {
		// TODO Auto-generated method stub
		BankAccount result= bankAccountRepository.getOne(accountID);
		
		if(result.getAccountBalance()<balance)
		{
			throw new LowBalanceException("Insufficient Amount to withdraw");		
		}
		
		result.setAccountBalance(result.getAccountBalance()-balance);
		bankAccountRepository.save(result);
		
		return result.getAccountBalance();
	
	}

	public double deposit(long accountID, double balance) {
		// TODO Auto-generated method stub
		BankAccount result=bankAccountRepository.getOne(accountID);
		
		result.setAccountBalance(result.getAccountBalance()+balance);
		bankAccountRepository.save(result);
	
		return result.getAccountBalance();
	}

	public double getBalance(long accountID) {
		// TODO Auto-generated method stub
		return bankAccountRepository.getOne(accountID).getAccountBalance();
	}

	public boolean fundTransfer(long fromAccount, long toAccount, double balance)
			throws BankAccountNotFoundException, LowBalanceException {
		// TODO Auto-generated method stub
	
			BankAccount sendersAccount=bankAccountRepository.getOne(fromAccount);
			BankAccount reciversAccount=bankAccountRepository.getOne(toAccount);
			
			if(sendersAccount==null || reciversAccount==null)
			{
				throw new BankAccountNotFoundException("Either of the account is not valid");
			}
			
			else if(sendersAccount.getAccountBalance()<balance)
			{
				throw new LowBalanceException("Not Sufficient amount to transfer"); 
			}
			else {
				sendersAccount.setAccountBalance(sendersAccount.getAccountBalance()-balance);
				reciversAccount.setAccountBalance(reciversAccount.getAccountBalance()+balance);
				bankAccountRepository.save(sendersAccount);
				bankAccountRepository.save(reciversAccount);
				
				return true;
			}
	}

}
