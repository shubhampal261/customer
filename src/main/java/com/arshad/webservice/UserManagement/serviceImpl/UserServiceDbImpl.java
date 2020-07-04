package com.arshad.webservice.UserManagement.serviceImpl;

import com.arshad.webservice.UserManagement.beans.User;
import com.arshad.webservice.UserManagement.beans.UserResponseModel;
import com.arshad.webservice.UserManagement.repo.UserJPARepository;
import com.arshad.webservice.UserManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("userServiceDbImpl")
public class UserServiceDbImpl implements UserService {

    @Autowired
    private UserJPARepository userRepository;

    public List<UserResponseModel> getAllUsers() {
        List <UserResponseModel> userList = mapUserListToUserResponseModelList(userRepository.findAll());
        return userList;
    }

    public UserResponseModel getUserByID(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return convertUserToUserResponseModel(userOptional.get());
        }
        return null;
    }

    public UserResponseModel addUser(User user) {
        user = userRepository.save(user);
        return convertUserToUserResponseModel(user);
    }

    @Override
    public UserResponseModel deleteUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return convertUserToUserResponseModel(user);
        }
        return null;
    }

    private List mapUserListToUserResponseModelList(List<User> users) {
        List<UserResponseModel> userList = new ArrayList();
        for (User user : users) {
            UserResponseModel userModel = convertUserToUserResponseModel(user);
            userList.add(userModel);
        }
        return userList;
    }

    private UserResponseModel convertUserToUserResponseModel(User user) {
        UserResponseModel userModel = new UserResponseModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setBirthDate(user.getBirthDate());
        return userModel;
    }

}

