package com.indepth.restfulapi.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.indepth.restfulapi.mapper.UserMapper;
import com.indepth.restfulapi.pojo.User;
import com.indepth.restfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserServiceImpl
 *
 * @author dusk
 * @since 30/10/2019
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isExist(String name) {
        return getByName(name).isPresent();
    }

    @Override
    public Optional<User> getByName(String name) {
        return Optional.ofNullable(userMapper.selectOne(Wrappers.<User>lambdaQuery().like(User::getUsername, name)));
    }

    @Override
    public Optional<User> get(String userName, String password) {
        return Optional.ofNullable(userMapper.selectOne(Wrappers.<User>lambdaQuery()
                .and(o -> o.eq(User::getUsername, userName).eq(User::getPassword, password))));
    }
}
