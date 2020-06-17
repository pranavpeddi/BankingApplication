package com.example.BankingApplicationAPI.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BankingApplicationAPI.Model.Statement;

import java.util.List;
import java.util.Map;


@Repository
public interface StatementRepository extends CrudRepository<Statement, Long> {
    List<Statement> findByAccountStatement_AID(long id);


    @Query(value = "select  action,amount,date,final_balance,time from Statement  where account_statement_aid=?1",nativeQuery = true)
    List<Map<String ,Object>> getStatementByAccountStatement_AID(long aid);
}
