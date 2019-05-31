package com.ramostear.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Created by Ramostear on 2019/5/31 0031.
 */
//@Configuration
public class AsyncSpringEventConfig {

    //@Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster applicationEventMulticaster(){
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return multicaster;
    }

}
