package com.expensetracker.simpleexpense.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TempDB {
    public static ArrayList<Transaction> getDatabaseData(){
        Transaction transaction1 = new Transaction();
        transaction1.setId(1L);
        transaction1.setAmount(100.0);
        transaction1.setUserId(1L);
        transaction1.setStatus("SUCCESS");
        transaction1.setTransactionType("DEPOSIT");
        transaction1.setDateTime(LocalDateTime.now());

        Transaction transaction2 = new Transaction();
        transaction2.setId(2L);
        transaction2.setAmount(150.0);
        transaction2.setUserId(1L);
        transaction2.setStatus("SUCCESS");
        transaction2.setTransactionType("DEBIT");
        transaction2.setDateTime(LocalDateTime.now());

        Transaction transaction3 = new Transaction();
        transaction3.setId(3L);
        transaction3.setAmount(200.0);
        transaction3.setUserId(1L);
        transaction3.setStatus("FAIL");
        transaction3.setTransactionType("DEPOSIT");
        transaction3.setDateTime(LocalDateTime.now());

        //transactions for user2
        Transaction transaction4 = new Transaction();
        transaction4.setId(4L);  // Incremented id
        transaction4.setAmount(120.0);
        transaction4.setUserId(2L);
        transaction4.setStatus("SUCCESS");
        transaction4.setTransactionType("WITHDRAWAL");
        transaction4.setDateTime(LocalDateTime.now());

        Transaction transaction5 = new Transaction();
        transaction5.setId(5L);  // Incremented id
        transaction5.setAmount(80.0);
        transaction5.setUserId(3L);
        transaction5.setStatus("SUCCESS");
        transaction5.setTransactionType("DEPOSIT");
        transaction5.setDateTime(LocalDateTime.now());

        Transaction transaction6 = new Transaction();
        transaction6.setId(6L);  // Incremented id
        transaction6.setAmount(200.0);
        transaction6.setUserId(4L);
        transaction6.setStatus("SUCCESS");
        transaction6.setTransactionType("DEPOSIT");
        transaction6.setDateTime(LocalDateTime.now());

        Transaction transaction7 = new Transaction();
        transaction7.setId(7L);  // Incremented id
        transaction7.setAmount(150.0);
        transaction7.setUserId(5L);
        transaction7.setStatus("SUCCESS");
        transaction7.setTransactionType("WITHDRAWAL");
        transaction7.setDateTime(LocalDateTime.now());

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        //user2 related transactions
        transactions.add(transaction4);
        transactions.add(transaction5);
        transactions.add(transaction6);
        transactions.add(transaction7);

        return transactions;
    }
}
