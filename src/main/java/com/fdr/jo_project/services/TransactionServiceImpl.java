package com.fdr.jo_project.services;

import com.fdr.jo_project.dto.OfferDTO;
import com.fdr.jo_project.dto.TransactionDTO;
import com.fdr.jo_project.entities.Offer;
import com.fdr.jo_project.entities.Transaction;
import com.fdr.jo_project.repositories.TransactionRepository;
import com.fdr.jo_project.util.CustomTokenUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TransactionDTO saveTransaction(TransactionDTO t) {
        t.setDateTransaction(Date.valueOf(LocalDate.now()));
        return convertEntityToDTO(transactionRepository.save(convertDTOToEntity(t)));
    }
//    @Override
//    public Transaction saveTransaction(Transaction t){
//        String token = CustomTokenUtil.generateCustomToken();
//        Transaction transaction = null;
//
//        transaction.setTokenTransaction(token);
//        transaction.setDateTransaction(Date.valueOf(LocalDate.now()));
//        return transactionRepository.save(transaction);
//    }

    @Override
    public TransactionDTO updateTransaction(TransactionDTO t) {
        return convertEntityToDTO(transactionRepository.save(convertDTOToEntity(t)));
    }

    @Override
    public TransactionDTO getTransaction(Long id) {
        return convertEntityToDTO(transactionRepository.findById(id).get());
    }
    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTransaction(Transaction t) {

    }
    @Override
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public TransactionDTO convertEntityToDTO(Transaction t) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TransactionDTO transactionDTO = modelMapper.map(t, TransactionDTO.class);
        return transactionDTO;
    }
    @Override
    public Transaction convertDTOToEntity(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction = modelMapper.map(transactionDTO, Transaction.class);
        return transaction;
    }

}
