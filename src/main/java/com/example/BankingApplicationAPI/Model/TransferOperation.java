package com.example.BankingApplicationAPI.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class TransferOperation extends Operations {

	public TransferOperation(LocalDate date, LocalTime time, double balance, Account account) {
		super(date, time, balance, account);
		
	}

	public TransferOperation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
