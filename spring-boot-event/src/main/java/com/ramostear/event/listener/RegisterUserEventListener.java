package com.ramostear.event.listener;

import com.ramostear.domain.EmailDetail;
import com.ramostear.domain.User;
import com.ramostear.event.SendEmailEvent;
import com.ramostear.repository.EmailDetailRepository;
import com.ramostear.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Ramostear on 2019/5/31 0031.
 */
@Slf4j
@Component
public class RegisterUserEventListener {

    @Autowired
    private EmailDetailRepository emailDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Async
    @EventListener
    public void sendEmail(SendEmailEvent event){
        Optional<User> optional = userRepository.findById(event.getUserId());
        if(optional.isPresent()){
            User user = optional.get();
            log.info("User Detail:{ id:{},firstName:{},email:{}",user.getId(),user.getFirstName(),user.getEmail());
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                log.error(e.getLocalizedMessage());
            }

            emailDetailRepository.save(EmailDetail.builder().
                    userId(user.getId()).
                    email(user.getEmail()).
                    sendTime(new Date()).
                    build());
            log.info("User email already send.");
        }

    }


}
