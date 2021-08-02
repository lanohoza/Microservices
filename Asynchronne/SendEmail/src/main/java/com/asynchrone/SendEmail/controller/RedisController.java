package com.asynchrone.SendEmail.controller;

import com.asynchrone.SendEmail.service.RedisMessageSubscriber;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/redis")
public class RedisController {

@GetMapping("/subscribe")
    public String getMessages(){
        return RedisMessageSubscriber.msg;
    }


}