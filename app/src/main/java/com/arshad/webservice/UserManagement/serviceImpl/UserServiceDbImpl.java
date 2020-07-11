package com.arshad.webservice.UserManagement.serviceImpl;

import com.arshad.webservice.UserManagement.beans.User;
import com.arshad.webservice.UserManagement.beans.UserResponseModel;
import com.arshad.webservice.UserManagement.mapper.UserMapper;
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
        List<UserResponseModel> userList = UserMapper.INSTANCE.mapToUserResponseModelList(userRepository.findAll());
        return userList;
    }

    public UserResponseModel getUserByID(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return UserMapper.INSTANCE.mapToUserResponseModel(userOptional.get());
        }
        return null;
    }

    public UserResponseModel addUser(User user) {
        user = userRepository.save(user);
        return UserMapper.INSTANCE.mapToUserResponseModel(user);
    }

    @Override
    public UserResponseModel deleteUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return UserMapper.INSTANCE.mapToUserResponseModel(user);
        }
        return null;
    }

}

