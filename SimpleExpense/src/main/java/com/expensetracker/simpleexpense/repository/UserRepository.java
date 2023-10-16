package com.expensetracker.simpleexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.simpleexpense.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
