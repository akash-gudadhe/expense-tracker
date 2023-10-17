package com.expensetracker.simpleexpense.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.simpleexpense.model.TempDB;
import com.expensetracker.simpleexpense.model.Transaction;
import com.expensetracker.simpleexpense.service.TransactionService;
import com.expensetracker.simpleexpense.service.UserService;

@RequestMapping("/expensetracker/")
@RestController
public class ExpenseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;
   

    @GetMapping(value = "/health")
    public String health(){
        return "OK";
    }
  
    // @Cacheable(value = "allUserTransactions")
    @GetMapping(value = "transactions")
    public Object getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    //transaction based on user id
    // @Cacheable(value = "transactionCache", key="#userId")
    @GetMapping(value = "transactions/{userId}")
    public ResponseEntity<?> getAllTransactionsOfUser(@PathVariable("userId") Long uId){
        ArrayList<Transaction> transactions = TempDB.getDatabaseData();
        List<Transaction> userTransactions = transactions.stream()
                    .filter(t -> t.getUserId() == uId)
                    .collect(Collectors.toList());

        
        return userTransactions.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Transactions found for user"+uId) : ResponseEntity.ok(userTransactions);
    }

    @GetMapping("user/{userId}")
    public String userDetails(@PathVariable Long userId){
        return userService.userExists(userId) ? "User Exists" : "UserNotFound";
    }

}
