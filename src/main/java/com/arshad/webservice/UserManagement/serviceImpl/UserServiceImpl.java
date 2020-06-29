package com.arshad.webservice.UserManagement.serviceImpl;

import com.arshad.webservice.UserManagement.beans.User;
import com.arshad.webservice.UserManagement.repo.UserRepository;
import com.arshad.webservice.UserManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService {
    private static int userCount = 2;
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, "Arshad", new Date(), new Date(), new Date()));
        userList.add(new User(2, "Shubham", new Date(), new Date(), new Date()));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserByID(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User addUser(User user) {
        user.setId(++userCount);
        userList.add(user);
        return user;
    }

    @Override
    public User deleteUserById(int id) {
        Iterator<User> itr = userList.iterator();
        while (itr.hasNext()) {
            User user = itr.next();
            if (user.getId() == id) {
                userList.remove(user);
                return user;
            }
        }
        return null;
    }

}
