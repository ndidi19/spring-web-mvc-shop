package com.ndiaye.m2ishop.repository;

import com.ndiaye.m2ishop.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
