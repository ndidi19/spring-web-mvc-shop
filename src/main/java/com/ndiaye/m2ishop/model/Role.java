package com.ndiaye.m2ishop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Role {

    @Id
    private String id;
    private String role;

    public Role(String role) {
        this.role = role;
    }
}
