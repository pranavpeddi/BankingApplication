package com.example.BankingApplicationAPI.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingApplicationAPI.Model.Account;
import com.example.BankingApplicationAPI.Model.DepositOperation;
import com.example.BankingApplicationAPI.Model.Operations;
import com.example.BankingApplicationAPI.Model.Statement;
import com.example.BankingApplicationAPI.Model.WithDrawOperation;
import com.example.BankingApplicationAPI.Repository.AccountRepository;
import com.example.BankingApplicationAPI.Repository.OperationsRepository;
import com.example.BankingApplicationAPI.Repository.StatementRepository;

@Service
public class BankingService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private StatementRepository statementRepository;
	
	@Autowired
	private OperationsRepository operationsRepository;
	
	public void saveAccount(Account account)
	{
		accountRepository.save(account);
	}
	
	
	public void saveOperations(Operations operations)
	{
		operationsRepository.save(operations);
	}
	
	public void saveStatement(Statement statement)
	{
	   statementRepository.save(statement);
	}
	
	
	public List<Account> getAll()
	{
		return (List<Account>) accountRepository.findAll();
	}
	
	public void deposit(long id,double amount)
	{
		
	
		Account account=accountRepository.findByAID(id);
		System.out.println("account is :"+account);
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.now();
		DepositOperation depositOperation=new DepositOperation(date, time, amount, account);
		operationsRepository.save(depositOperation);
		Statement statement=new Statement("Deposited",amount, account.getBalance()+amount, date, account,time);
	statementRepository.save(statement);
		
	    account.setBalance(account.getBalance()+amount);
	    accountRepository.save(account);
	   
	}
	
	public String  transfer(long fromId,long toId,double amount)
	{
		if(fromId==0L)
		{
			return "from account is not present";
		}
		else if(toId==0L)
		{
			return "to account is not present";
		}
		
		if(fromId!=toId)
		{
			Account account1=accountRepository.findByAID(fromId);
			LocalDate date=LocalDate.now();
			LocalTime time=LocalTime.now();
			WithDrawOperation withDrawOperation=new WithDrawOperation(date, time,amount,account1);
			operationsRepository.save(withDrawOperation);
			Statement st1=new Statement("Transfered", amount, account1.getBalance()-amount, date, account1,time);
			account1.setBalance(st1.getAmount()-amount);
			accountRepository.save(account1);
			Account account2=accountRepository.findByAID(toId);
			DepositOperation depositOperation=new DepositOperation(date,time,amount,account2);
			operationsRepository.save(depositOperation);
			Statement st2=new Statement("Credited", amount, account2.getBalance()+amount, date, account2,time);
			statementRepository.save(st2);
			account2.setBalance(account2.getBalance()+amount);
			return "transfered successfully";
			
		}
		
		return "null";
	}
	
	
}
