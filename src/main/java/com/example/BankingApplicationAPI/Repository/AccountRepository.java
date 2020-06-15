package com.example.BankingApplicationAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BankingApplicationAPI.Model.Account;


@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
      Account findByAID(long id);
}
