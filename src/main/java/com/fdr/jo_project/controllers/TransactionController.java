package com.fdr.jo_project.controllers;

import com.fdr.jo_project.dto.TransactionDTO;
import com.fdr.jo_project.entities.Transaction;

import com.fdr.jo_project.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<TransactionDTO> getAllTickets(){
        return transactionService.getAllTransactions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TransactionDTO getTransactionById(@PathVariable("id") Long id){
        return transactionService.getTransaction(id);
    }

    //Méthode pour test
    @RequestMapping(method = RequestMethod.POST)
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO){
        return transactionService.saveTransaction(transactionDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public TransactionDTO updateTransaction(@RequestBody TransactionDTO transactionDTO){
        return transactionService.updateTransaction(transactionDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTransaction(@PathVariable("id") Long id){
        transactionService.deleteTransactionById(id);
    }
}
