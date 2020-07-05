package com.udacity.jdnd.c1.review;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {
    // add a private variable message and use it as the argument of the constructor
    // this tells Spring to find this bean and inject it
    private String message;
    // since this is an injected class, we can use its class method just like any other class
    public MessageService(String message) {
        this.message = message;
    }

    public String uppercase() {
        return this.message.toUpperCase();
    }

    public String lowercase() {
        return this.message.toLowerCase();
    }

    // method use to log the creation of beans. You can also do this in the constructor, but the general
    // practice is to put this in a dedicated method
    @PostConstruct
    public void postConstruct() {
        System.out.println(("Creating MessageService bean"));
    }
}
