package com.mapper;


import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    boolean login(String username, String password);

    void addUser(String username, String password);

    List<User> findUsers();

    void deleteUser(Integer eid);

    User getUserById(String username);

    void updateUser(User user);
}
