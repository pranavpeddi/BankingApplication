package com.example.BankingApplicationAPI.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity

public class Statement {

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private long Sid;
	private String action;
	private double amount;
	private double finalBalance;
	private LocalDate date;
	private LocalTime time;
	
	@ManyToOne
	private Account accountStatement;

	
	public Statement() {
		
	}
	public Statement( String action, double amount, double finalBalance, LocalDate date, Account account,LocalTime time) {
		super();
	
		this.action = action;
		this.amount = amount;
		this.finalBalance = finalBalance;
		this.date = date;
		this.accountStatement = account;
		this.time=time;
	}

	public long getSid() {
		return Sid;
	}

	public void setSid(long sid) {
		Sid = sid;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(double finalBalance) {
		this.finalBalance = finalBalance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Account getAccountStatement() {
		return accountStatement;
	}

	public void setAccountStatement(Account account) {
		this.accountStatement = account;
	}
	
	
	
	
	
	

}
