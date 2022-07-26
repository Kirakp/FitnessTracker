package com.cg.ft.controller;

import com.cg.ft.entities.User;
import com.cg.ft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fitness")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

//    public ResponseEntity<User> getUser(Integer id){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(""))
//    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/fitness/register").toUriString());
        return ResponseEntity.created(uri).body(userService.registerUser(user));
    }

    @PutMapping(path = "login/")
    public User loginUser(@RequestParam(required = true) String userValue,
                          @RequestBody(required = true) String password) {
        return userService.loginUser(userValue, password);
    }

//    @PutMapping(path = "update_user/")
//    public User updateUser(@RequestParam(required = true) String userValue,
//                           @RequestBody(required = true) User user){
//        return userService.UpdateUser(userValue,user);

    @PutMapping(path = "update_user/{id}")
    public User updateUser(@PathVariable Integer id ,
                           @RequestBody(required = true) User user){
        return userService.UpdateUser(id,user);
    }
}
