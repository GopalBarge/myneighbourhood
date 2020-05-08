package com.bs.myneighbourhood.controller;

import com.bs.myneighbourhood.Service.person.UserService;
import com.bs.myneighbourhood.api.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/all")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity getUserByName(@PathVariable("name") String name){
        return new ResponseEntity(userService.get(name), HttpStatus.OK);
    }
    @PostMapping("{name}/friends")
    public ResponseEntity addFriends(@PathVariable("name") String name, @RequestBody List<String> friends){

        return new ResponseEntity(userService.addRelation(name,friends), HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserDTO user){

        return new ResponseEntity(userService.save(user.getFirstName()), HttpStatus.OK);
    }
}
