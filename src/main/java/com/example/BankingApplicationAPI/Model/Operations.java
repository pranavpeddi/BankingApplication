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
public class Operations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long OID;
	private LocalDate date;
	private LocalTime time;
	private double balance;
	
	@ManyToOne
	private Account account;

	
	public Operations()
	{
		
	}
	
	public Operations( LocalDate date, LocalTime time, double balance, Account account) {
		super();
		
		this.date = date;
		this.time = time;
		this.balance = balance;
		this.account = account;
	}

	public long getOID() {
		return OID;
	}

	public void setOID(long oID) {
		OID = oID;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Operations that = (Operations) o;
		return OID == that.OID &&
				Double.compare(that.balance, balance) == 0 &&
				Objects.equals(date, that.date) &&
				Objects.equals(time, that.time) &&
				Objects.equals(account, that.account);
	}

	@Override
	public int hashCode() {
		return Objects.hash(OID, date, time, balance, account);
	}

//	@Override
//	public String toString() {
//		return "Operations{" +
//				"OID=" + OID +
//				", date=" + date +
//				", time=" + time +
//				", balance=" + balance +
//				", account=" + account +
//				'}';
//	}
}
