package com.arshad.webservice.UserManagement.user;

import org.springframework.data.crossstore.HashMapChangeSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceDAO {

    private static int userCount=2;
    private static  List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1,"Arshad", new Date()));
        userList.add(new User(2,"Shubham", new Date()));
    }

    public List<User> getAllUsers(){
        return userList;
    }

    public User getUserByID(int id){
        for(User user : userList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User addUser(User user){
        user.setId(++userCount);
        userList.add(user);
        return user;
    }
}
