package com.expensetracker.simpleexpense.service;

import org.springframework.stereotype.Service;

public interface TransactionService {
    public Object getTransactionsOfUser(Long userId);
    public Object getAllTransactions();
}
