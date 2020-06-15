package com.example.BankingApplicationAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BankingApplicationAPI.Model.Statement;

import java.util.List;


@Repository
public interface StatementRepository extends CrudRepository<Statement, Long> {
    List<Statement> findByAccountStatement_AID(long id);

}
