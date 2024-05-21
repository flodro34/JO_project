package com.fdr.jo_project.controllers;

import com.fdr.jo_project.entities.Transaction;
import com.fdr.jo_project.entities.User;
import com.fdr.jo_project.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/transaction")
@CrossOrigin
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Transaction> getAllTickets(){
        return transactionService.getAllTransactions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable("id") Long id){
        return transactionService.getTransaction(id);
    }

    //Méthode pour test
    @RequestMapping(method = RequestMethod.POST)
    public Transaction createUser(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Transaction updateTransaction(@RequestBody Transaction transaction){
        return transactionService.updateTransaction(transaction);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTransaction(@PathVariable("id") Long id){
        transactionService.deleteTransactionById(id);
    }
}
