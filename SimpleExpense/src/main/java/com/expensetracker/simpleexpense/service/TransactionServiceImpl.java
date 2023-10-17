package com.expensetracker.simpleexpense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.simpleexpense.model.Transaction;
import com.expensetracker.simpleexpense.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Object getTransactionsOfUser(Long userId){
        return null;
    }

    @Override
    public Object  getAllTransactions(){
        System.out.println("inside impl of transaction service");
        List<Transaction> transactions = transactionRepository.findAll();
        if(! transactions.isEmpty()){
            for(Transaction t : transactions){
                System.out.println(t.toString());
            }
        }else{
            System.out.println("no transactions");
        }
        return transactions;
    }
}
