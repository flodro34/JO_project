package com.fdr.jo_project.services;

import com.fdr.jo_project.dto.TransactionDTO;
import com.fdr.jo_project.entities.Offer;
import com.fdr.jo_project.entities.Transaction;

import java.util.List;

public interface TransactionService {

    TransactionDTO saveTransaction(TransactionDTO t);
    TransactionDTO updateTransaction(TransactionDTO t);

    TransactionDTO getTransaction(Long id);
    List<TransactionDTO> getAllTransactions();

    void deleteTransaction(Transaction t);
    void deleteTransactionById(Long id);


    TransactionDTO convertEntityToDTO(Transaction t);
    Transaction convertDTOToEntity(TransactionDTO TransactionDTO);
}
