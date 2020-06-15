package com.example.BankingApplicationAPI.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class WithDrawOperation extends Operations {
	
	


	public WithDrawOperation(LocalDate date, LocalTime time, double balance, Account account) {
		super(date, time, balance, account);
		
	}

	public WithDrawOperation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
