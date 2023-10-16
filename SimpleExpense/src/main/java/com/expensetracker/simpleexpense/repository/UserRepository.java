package com.expensetracker.simpleexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.simpleexpense.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
