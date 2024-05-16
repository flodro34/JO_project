package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Transaction;

import java.util.List;
import java.util.Optional;

public class TransactionServiceImpl implements TransactionService{
    @Override
    public Transaction saveTransaction(Transaction t) {
        return null;
    }

    @Override
    public Transaction updateTransaction(Transaction t) {
        return null;
    }

    @Override
    public void deleteTransaction(Transaction t) {

    }

    @Override
    public void deleteTransactionById(Long id) {

    }

    @Override
    public Optional<Transaction> getUser(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Transaction> getAllUsers() {
        return List.of();
    }
}
