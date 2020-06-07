package com.arshad.webservice.UserManagement.services;

import com.arshad.webservice.UserManagement.beans.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserByID(int id);

    public User addUser(User user);

    public User deleteUserById(int id);
}
