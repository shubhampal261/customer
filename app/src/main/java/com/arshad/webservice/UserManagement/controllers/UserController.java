package com.arshad.webservice.UserManagement.controllers;

import com.arshad.webservice.UserManagement.beans.User;
import com.arshad.webservice.UserManagement.beans.UserResponseModel;
import com.arshad.webservice.UserManagement.services.UserService;
import com.arshad.webservice.UserManagement.utils.UserConstants;
import com.arshad.webservice.UserManagement.utils.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "v1/user-management")
public class UserController {

    @Autowired
//    @Qualifier(value = "userServiceImpl")
    @Qualifier(value = "userServiceDbImpl")
    private UserService userServiceImpl;

    @GetMapping(path = "/user")
    public List<UserResponseModel> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    @GetMapping(path = "/user/{id}")
    public UserResponseModel getUser(@PathVariable int id){
        UserResponseModel user = userServiceImpl.getUserByID(id);
        if(user == null){
            throw new UserNotFoundException(String.format(UserConstants.CANNOT_FIND_USER,id));
        }
        return user;
    }

    @PostMapping(path = "/user")
    public ResponseEntity addUser(@RequestBody User user){
        userServiceImpl.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        UserResponseModel user = userServiceImpl.deleteUserById(id);
        if(user == null){
            throw new UserNotFoundException(String.format(UserConstants.CANNOT_DELETE_USER,id));
        }
        return ResponseEntity.noContent().build();
    }

}
