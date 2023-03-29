package com.fit.service;

import com.fit.domain.User;
import com.fit.mapper.UserMapper;
import org.mybatis.guice.transactional.Transactional;
import com.google.inject.Inject;

import java.util.List;

public class UserService {

    private final UserMapper userMapper;

    @Inject
    UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Transactional
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Transactional
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Transactional
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }
}
