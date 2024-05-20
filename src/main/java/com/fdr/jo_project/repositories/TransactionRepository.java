package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "transaction")
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
}
