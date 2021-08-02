package com.asynchrone.SendEmail.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber implements MessageListener {

    public static String msg;

    @Override
    public void onMessage(Message message, byte[] bytes) {

        msg=message.toString();
        System.out.println("Message received : " + msg);
    }


}
