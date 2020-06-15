package com.example.BankingApplicationAPI.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class DepositOperation extends Operations {

	public DepositOperation(LocalDate date, LocalTime time, double balance, Account account) {
		super(date, time, balance, account);
		// TODO Auto-generated constructor stub
	}

	public DepositOperation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
