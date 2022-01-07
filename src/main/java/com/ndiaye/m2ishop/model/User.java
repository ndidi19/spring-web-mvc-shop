package com.ndiaye.m2ishop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Address address;
    private Set<Role> roles;

    public User(String firstname, String lastname, String email, String password, Address address, Set<Role> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.roles = roles;
    }
}
