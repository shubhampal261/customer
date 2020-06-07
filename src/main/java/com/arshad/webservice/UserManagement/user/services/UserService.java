package com.arshad.webservice.UserManagement.user.services;

import com.arshad.webservice.UserManagement.user.beans.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserByID(int id);

    public User addUser(User user);
}
