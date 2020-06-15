package com.example.BankingApplicationAPI.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long AID;
	
	private String AccountName;
	private String accountEmail;
	private double balance;
    @OneToMany(mappedBy = "account")
	private List<Operations> operations=new ArrayList<>();
  @OneToMany(mappedBy = "accountStatement")
    List<Statement> statements=new ArrayList<>();
    
    
    public Account()
    {
    	
    }
    
	public Account(long id, String accountName, String accountEmail, double balance, List<Operations> operations) {
		
		this.AID = id;
		AccountName = accountName;
		this.accountEmail = accountEmail;
		this.balance = balance;
		this.operations = operations;
	}
	public long getAID() {
		return AID;
	}
	public void setAID(long id) {
		this.AID = id;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Operations> getOperations() {
		return operations;
	}
	public void setOperations(List<Operations> operations) {
		this.operations = operations;
	}
    
    
    
    
	

}
