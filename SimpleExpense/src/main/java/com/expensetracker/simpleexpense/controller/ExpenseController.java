package com.expensetracker.simpleexpense.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/expensetracker/")
@RestController
public class ExpenseController {
    //health check
    //welcome message
    @GetMapping(value = "welcome")
    public String welcomeUser(){
        return "Welcome to expense tracker app";
    }
}
