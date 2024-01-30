package com.JetEye20.JetEye20.API;

import com.JetEye20.JetEye20.Repos.PointRepository;
import com.JetEye20.JetEye20.Repos.UserRepository;

import com.JetEye20.JetEye20.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AuthController {

    private UserRepository userRepository;


    @PostMapping("/registration")
    public ResponseEntity createUser(@RequestBody User user){


        for(User user1 :userRepository.findAll()){
            if (user1.getUsername().equals(user.getUsername())){
                return ResponseEntity.ok("Cannot create new user with this username " + user.getUsername()  + " time " + new Date());
            }
        }

        User newUser = User.builder()
                .isAdmin(user.isAdmin())
                .phoneNumber(user.getPhoneNumber())
                .username(user.getUsername())
                .password(user.getPassword()).build();


       userRepository.save(newUser);

        return ResponseEntity.ok("Created new user " + user.getUsername()  + " at " + new Date());
    }

    @GetMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user){

        User loginDt = userRepository.findByUsername(user.getUsername());
        if (loginDt.getPassword().equals(user.getPassword())){
            if (loginDt.isAdmin()) {
                return ResponseEntity.ok("Welcome  admin " + loginDt.getUsername()  + " you entry at " + new Date());
            }else{
                return ResponseEntity.ok("Welcome driver " + loginDt.getUsername()  + " you entry at " + new Date());
            }

        }

        return ResponseEntity.ok("Authorization problems check your data  and try again: last try at " + new Date());
    }
}
