package com.expensetracker.simpleexpense.service;

import com.expensetracker.simpleexpense.model.User;

public interface UserService {
    public Object getUserDetails(Long userId);
    public User registerUser(User user);
}
