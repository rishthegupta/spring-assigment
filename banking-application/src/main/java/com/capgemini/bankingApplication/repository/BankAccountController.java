package com.capgemini.bankingApplication.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bankingApplication.bean.BankAccount;
import com.capgemini.bankingApplication.service.BankAccountNotFoundException;
import com.capgemini.bankingApplication.service.LowBalanceException;
import com.capgemini.bankingApplication.service.impl.BankAccountServiceImpl;

@RestController
@RequestMapping("/bank")
public class BankAccountController {
	
	@Autowired
	private BankAccountServiceImpl bankServiceImpl;
	
	@GetMapping(value = "/allAccounts")
	public ResponseEntity<List<BankAccount>> fetchAllCustomers()
	{
		return ResponseEntity.accepted().body(bankServiceImpl.fetchAllAccounts());
	}
	
	@GetMapping(value = "/fetchOneUser/{accountID}")
	public ResponseEntity<BankAccount> fetchOneUser(@PathVariable long accountID) throws BankAccountNotFoundException
	{
		return ResponseEntity.accepted().body(bankServiceImpl.fetchAccount(accountID));
	}
	
	@GetMapping(value = "/depositBalance/{accountID}/{balance}")
	public ResponseEntity<Double> depositBalance(@PathVariable long accountID, @PathVariable double balance)
	{
		return ResponseEntity.accepted().body(bankServiceImpl.deposit(accountID, balance));
	}
	
	@GetMapping(value = "/withdrawBalance/{accountID}/{balance}")
	public ResponseEntity<Double> withdrawBalance(@PathVariable long accountID, @PathVariable double balance) throws LowBalanceException
	{
		return ResponseEntity.accepted().body(bankServiceImpl.withdraw(accountID, balance));
	}
	
	
	@GetMapping(value = "/fundTransfer/{accountID1}/{accountID2}/{balance}")
	public ResponseEntity<Boolean> fundTransfer(@PathVariable long accountID1, @PathVariable long accountID2, @PathVariable double balance) throws BankAccountNotFoundException, LowBalanceException
	{
		
		return ResponseEntity.accepted().body(bankServiceImpl.fundTransfer(accountID1, accountID2, balance));
	}
	
	@GetMapping(value = "/getBalance/{accountID}")
	public ResponseEntity<Double> getBalance(@PathVariable long accountID)
	{

		return ResponseEntity.accepted().body(bankServiceImpl.getBalance(accountID));
	}
	
	
	
	
}
