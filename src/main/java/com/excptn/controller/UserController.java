package com.excptn.controller;

import com.excptn.exceptions.UserNotFoundException;
import com.excptn.dto.UserRequest;
import com.excptn.entity.User;
import com.excptn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(Optional.ofNullable(userService.getOneUserById(id)));
    }
}
