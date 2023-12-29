package com.example.librarymanagementbackend.Controllers;

import com.example.librarymanagementbackend.user.User;
import com.example.librarymanagementbackend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/profile")
public class UserInfoController {

    @Autowired
    private UserService userService;


//    @GetMapping("/me")
//    public ResponseEntity<User> getUserData() {
//        User user = userService.findAll().get(0);
////        System.out.println(user);
//        return ResponseEntity.ok(user);
//    }

    @GetMapping("/me")
    public String fetchUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    }
//    @GetMapping("/me")
//    public ResponseEntity<String> getJsonData() {
//        String jsonString = "{\n" +
//                "  \"email\": \"ziadhany2016@gmail.com\",\n" +
//                "  \"avatar\": \"https://avatars.githubusercontent.com/u/29133904?v=4\",\n" +
//                "  \"userName\": \"ziadhany\",\n" +
//                "  \"isAdmin\": false,     \n" +
//                "  \"role\": \"string\",\n" +
//                "  \"_id\": \"1\"\n" +
//                "}";
//        return ResponseEntity.ok(jsonString);
//    }
