package com.JetEye20.JetEye20.models;



import jakarta.persistence.UniqueConstraint;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "user")
@Data
@Builder
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;


    private String phoneNumber;

    private String password;



    private boolean isAdmin;

}
