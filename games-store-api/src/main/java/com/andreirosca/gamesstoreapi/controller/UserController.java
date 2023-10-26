//package com.andreirosca.gamesstoreapi.controller;
//
//import com.andreirosca.gamesstoreapi.model.Game;
//import com.andreirosca.gamesstoreapi.model.user_account.UserAccount;
//import com.andreirosca.gamesstoreapi.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/games")
//public class UserController {
//
//    @Autowired
//    private UserService service;
//    @PostMapping("/users")
//    public ResponseEntity<UserAccount> createUser(UserAccount userAccount){
//        UserAccount userAccountNew = service.createUser(userAccount);
//
//        return new ResponseEntity<>(userAccountNew, HttpStatus.CREATED);
//
//    }
//    @GetMapping("/users")
//    public ResponseEntity<List<UserAccount>> getAllUsers(){
//        List<UserAccount> userAccounts = service.getAllUsers();
//
//        if(userAccounts.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(userAccounts, HttpStatus.OK);
//    }
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity<UserAccount> getUser(@PathVariable("id") UUID id){
//        UserAccount userAccountFound = service.getUser(id);
//
//        return new ResponseEntity<>(userAccountFound, HttpStatus.OK);
//    }
//    @PutMapping("/users/{id}")
//    public ResponseEntity<UserAccount> updateUser(@PathVariable("id") UUID id, @RequestBody UserAccount userAccount){
//        UserAccount userAccountUpdated = service.updateUser(id, userAccount);
//
//
//
//        return new ResponseEntity<>(userAccountUpdated, HttpStatus.OK);
//    }
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<Game> deleteUser(@PathVariable("id") UUID id) {
//
//        service.deleteUser(id);
//        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping("/users")
//    public ResponseEntity<HttpStatus> deleteAllUsers() {
//        service.deleteAllUsers();
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
