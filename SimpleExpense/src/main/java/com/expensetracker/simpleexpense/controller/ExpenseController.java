package com.expensetracker.simpleexpense.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);
    
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;


    @GetMapping(value = "/health")
    public String health(){
        MDC.put("mdcuserId", "akash");
        logger.info("Application is running.");
        MDC.remove("mdcuserId");
        return "OK";
    }
  
    //TODO: make it secure
    // @Cacheable(value = "allUserTransactions")
    @GetMapping(value = "transactions")
    public Object getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    //TODO: make it secure
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

    @GetMapping("datasource")
    public String dataSourceData(){
        // try{
        //     Connection connectionDs1 = datasource.getConnection();
        //     String sqlQuery = "SELECT * FROM Transaction";
        //     PreparedStatement ps = connectionDs1.prepareStatement(sqlQuery);
        //     ResultSet result = ps.executeQuery();

        //     while(result.next()){
        //         System.out.println(result.getLong("id"));
        //     }
        // }catch(SQLException e){
        //     e.printStackTrace();
        // }
        return null;
    }

}
