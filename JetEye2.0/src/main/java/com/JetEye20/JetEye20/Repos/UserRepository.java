package com.JetEye20.JetEye20.Repos;


import com.JetEye20.JetEye20.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {

    User findById(String userId);
    User findByUsername(String username);}
