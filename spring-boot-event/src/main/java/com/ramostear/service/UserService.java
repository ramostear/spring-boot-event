package com.ramostear.service;

import com.ramostear.domain.User;

/**
 * Created by Ramostear on 2019/5/31 0031.
 */
public interface UserService {

    User created(User user);


    User findOne(Long id);
}
