package com.expensetracker.simpleexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.simpleexpense.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
