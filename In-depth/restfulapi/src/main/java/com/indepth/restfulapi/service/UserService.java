package com.indepth.restfulapi.service;

import com.indepth.restfulapi.pojo.User;

import java.util.Optional;

/**
 * UserService
 *
 * @author dusk
 * @since 30/10/2019
 */
public interface UserService {
    boolean isExist(String name);

    Optional<User> getByName(String name);

    Optional<User> get(String userName, String password);
}
