package com.capgemini.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capgemini.bankingApplication.bean.BankAccount;


@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{
	
	
}
