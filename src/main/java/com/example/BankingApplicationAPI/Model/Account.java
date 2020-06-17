package com.example.BankingApplicationAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long AID;
	
	private String AccountName;
	private String accountEmail;
	private double balance;
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
	private List<Operations> operations=new ArrayList<>();
  @OneToMany(mappedBy = "accountStatement",fetch = FetchType.LAZY)
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
//	public List<Operations> getOperations() {
	//	return operations;
	//}
	public void setOperations(List<Operations> operations) {
		this.operations = operations;
	}


	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return AID == account.AID &&
				Double.compare(account.balance, balance) == 0 &&
				Objects.equals(AccountName, account.AccountName) &&
				Objects.equals(accountEmail, account.accountEmail) &&
				Objects.equals(operations, account.operations) &&
				Objects.equals(statements, account.statements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(AID, AccountName, accountEmail, balance, operations, statements);
	}

//	@Override
//	public String toString() {
//		return "Account{" +
//				"AID=" + AID +
//				", AccountName='" + AccountName + '\'' +
//				", accountEmail='" + accountEmail + '\'' +
//				", balance=" + balance +
//				", operations=" + operations +
//				", statements=" + statements +
//				'}';
//	}
}
