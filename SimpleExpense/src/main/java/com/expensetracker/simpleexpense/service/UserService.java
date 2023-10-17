package com.expensetracker.simpleexpense.service;

import org.springframework.stereotype.Service;

public interface UserService {
    public boolean userExists(Long userId);
}
