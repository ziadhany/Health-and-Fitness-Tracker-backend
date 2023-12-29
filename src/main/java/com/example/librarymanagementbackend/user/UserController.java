package com.example.librarymanagementbackend.user;

import com.example.librarymanagementbackend.book.Book;
//import com.example.librarymanagementbackend.config.JwtService;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

import com.example.librarymanagementbackend.user.UserService;
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
//  private final JwtService jws_service;

//    @GetMapping("/me")
//    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String authHeader) {
////        final String jwt;
////        final String userEmail;
////        jwt = authHeader.substring(7);
////        userEmail = jws_service.extractClaim(jwt, Claims::getSubject);
//        return ResponseEntity.ok(service.findBookById(1));
//    }

//    @GetMapping("me")
//    public User findById() {
//        return service.findById(1);
//    }

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
}
