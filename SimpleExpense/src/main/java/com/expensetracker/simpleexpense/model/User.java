package com.expensetracker.simpleexpense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "sysuser")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
    @Column(unique = true)
    private String email;
    private Long phoneNumber;
}

// id
// firstName
// lastName
// email
// phoneNumber
