package com.service;

import com.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    Boolean login(String username, String password);

    void addUser(String username, String password);

    List<User> findusers();

    void deleteuser(Integer eid);

    User getUserById(String username);

    void updateUser(User user);
}
