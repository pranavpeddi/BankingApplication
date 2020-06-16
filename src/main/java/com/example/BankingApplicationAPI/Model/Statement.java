package com.example.BankingApplicationAPI.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity

public class Statement {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Statement(String action, double amount, double finalBalance, LocalDate date, Account account, LocalTime time) {
		super();

		this.action = action;
		this.amount = amount;
		this.finalBalance = finalBalance;
		this.date = date;
		this.accountStatement = account;
		this.time = time;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Statement statement = (Statement) o;
		return Sid == statement.Sid &&
				Double.compare(statement.amount, amount) == 0 &&
				Double.compare(statement.finalBalance, finalBalance) == 0 &&
				Objects.equals(action, statement.action) &&
				Objects.equals(date, statement.date) &&
				Objects.equals(time, statement.time) &&
				Objects.equals(accountStatement, statement.accountStatement);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Sid, action, amount, finalBalance, date, time, accountStatement);
	}

	@Override
	public String toString() {
		return "Statement{" +
				"Sid=" + Sid +
				", action='" + action + '\'' +
				", amount=" + amount +
				", finalBalance=" + finalBalance +
				", date=" + date +
				", time=" + time +
				", accountStatement=" + accountStatement.toString() +
				'}';
	}
}

