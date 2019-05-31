package com.ramostear.service.impl;

import com.ramostear.domain.User;
import com.ramostear.event.SendEmailEvent;
import com.ramostear.repository.UserRepository;
import com.ramostear.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Ramostear on 2019/5/31 0031.
 */
@Slf4j
@Service("userService")
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    UserServiceImpl(UserRepository userRepository,ApplicationEventPublisher applicationEventPublisher){
        this.userRepository = userRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User created(User user) {
        Date begin = new Date();
        userRepository.save(user);
        applicationEventPublisher.publishEvent(new SendEmailEvent(this,user.getId()));
        Date end = new Date();
        log.info("total times :"+(end.getTime()-begin.getTime()));
        return user;
    }

    @Override
    public User findOne(Long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.isPresent()?optional.get():new User();
    }
}
