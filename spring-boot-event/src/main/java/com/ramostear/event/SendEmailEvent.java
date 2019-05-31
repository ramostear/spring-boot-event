package com.ramostear.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Ramostear on 2019/5/31 0031.
 */
public class SendEmailEvent extends ApplicationEvent {

    @Getter
    private Long userId;

    public SendEmailEvent(Object source,Long userId) {
        super(source);
        this.userId = userId;
    }
}
