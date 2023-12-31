package com.expensetracker.simpleexpense.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.expensetracker.simpleexpense.model.RandomUser;
import com.expensetracker.simpleexpense.model.TempDB;
import com.expensetracker.simpleexpense.model.Transaction;
import com.expensetracker.simpleexpense.model.User;
import com.expensetracker.simpleexpense.repository.UserRepository;
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

     @Autowired
    private UserRepository userRepository;

    @QueryMapping
    public User getUser(Long id) {
        // Implement the logic to fetch a user by ID from your data source
        User byId = userRepository.getById(id);
        return (User) byId;
        
    }

    //TODO: make it secure
    // @Cacheable(value = "allUserTransactions")
    @Async
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
    public Object userDetails(@PathVariable Long userId){
        return userService.getUserDetails(userId);
    }

    @PostMapping("user")
    public Object registerUser(@RequestBody User user){
        return userService.registerUser(user);
    } 

    @GetMapping("random-user")
    public String getRandomUser(){
        RestTemplate restTemplate = new RestTemplate();

        // Set the API key in the header
        HttpHeaders headers = new HttpHeaders();
        
        //TODO: securely fetch key
        headers.set("X-Api-Key", System.getenv("prop")); 
        HttpEntity<String> entity = new HttpEntity<>(headers);

        final String url = "https://api.api-ninjas.com/v1/randomuser";

        // Make the request with the API key in the headers
        ResponseEntity<RandomUser> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, RandomUser.class);

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
        logger.warn(responseEntity.getBody().toString());
        return responseEntity.getBody().toString();
    }

    }
