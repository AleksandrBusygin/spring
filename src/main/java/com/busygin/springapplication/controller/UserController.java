package com.busygin.springapplication.controller;

import com.busygin.springapplication.service.UserService;
import com.busygin.springapplication.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController (final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        final List<User> users = userService.getUsers();

        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable final Integer id) {
        return this.userService.get(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("user")
    public ResponseEntity<User> addUser(@RequestBody final User user) {
        return new ResponseEntity<>(this.userService.add(user), HttpStatus.CREATED);
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> editUser(@PathVariable final Integer id, @RequestBody User user) {
        if (this.userService.edit(id, user)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable final Integer id, @RequestBody User user) {
        if (this.userService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
