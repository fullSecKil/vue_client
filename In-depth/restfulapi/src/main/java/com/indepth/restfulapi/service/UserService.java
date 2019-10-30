package com.indepth.restfulapi.service;

import com.indepth.restfulapi.pojo.User;

/**
 * UserService
 *
 * @author dusk
 * @since 30/10/2019
 */
public interface UserService {
    boolean isExist(String name);

    User getByName(String name);
}
