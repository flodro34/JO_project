package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction saveTransaction(Transaction t);
    Transaction updateTransaction(Transaction t);
    void deleteTransaction(Transaction t);
    void deleteTransactionById(Long id);
    Transaction getTransaction(Long id);
    List<Transaction> getAllTransactions();
}
