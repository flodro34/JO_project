package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Transaction;
import com.fdr.jo_project.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction t) {
        return transactionRepository.save(t);
    }

    @Override
    public Transaction updateTransaction(Transaction t) {
        return transactionRepository.save(t);
    }

    @Override
    public void deleteTransaction(Transaction t) {

    }

    @Override
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
