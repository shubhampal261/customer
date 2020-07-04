package com.arshad.webservice.UserManagement.services;

import com.arshad.webservice.UserManagement.beans.User;
import com.arshad.webservice.UserManagement.beans.UserResponseModel;

import java.util.List;

public interface UserService {

    public List<UserResponseModel> getAllUsers();

    public UserResponseModel getUserByID(int id);

    public UserResponseModel addUser(User user);

    public UserResponseModel deleteUserById(int id);
}
