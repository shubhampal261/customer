package com.arshad.webservice.UserManagement.serviceImpl;

import com.arshad.webservice.UserManagement.beans.User;
import com.arshad.webservice.UserManagement.repo.UserRepository;
import com.arshad.webservice.UserManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("userServiceDbImpl")
public class UserServiceDbImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByID(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public User addUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User deleteUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return user;
        }
        return null;
    }

}

