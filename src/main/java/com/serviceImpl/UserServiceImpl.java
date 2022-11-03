package com.serviceImpl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean login(String username, String password) {
        if (userMapper.login(username, password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addUser(String username, String password) {
        userMapper.addUser(username, password);
    }

    @Override
    public List<User> findusers() {
        return userMapper.findUsers();
    }

    @Override
    public void deleteuser(Integer eid) {
        userMapper.deleteUser(eid);
    }

    @Override
    public User getUserById(String username) {
        return userMapper.getUserById(username);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
