package com.expensetracker.simpleexpense.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.simpleexpense.controller.ExpenseController;
import com.expensetracker.simpleexpense.model.User;
import com.expensetracker.simpleexpense.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Object getUserDetails(Long userId){
       Optional<User> userFromDB = userRepository.findById(userId);
       
       if(userFromDB.isPresent()){
         return userFromDB.get();
       }
        
       return "No User Found";
    }

    @Override
    public User registerUser(User user){
        // System.out.println("inside usimpl");
        logger.warn(user.toString());
        

        // User userFromDB = userRepository.save(user);
  
        // '1', 'user1@example.com', 'John', 'Doe', 1234567890
        return null;
    }
}
