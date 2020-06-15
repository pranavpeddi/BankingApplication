package com.example.BankingApplicationAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BankingApplicationAPI.Model.Operations;


@Repository
public interface OperationsRepository extends CrudRepository<Operations,Long>{
  
}
