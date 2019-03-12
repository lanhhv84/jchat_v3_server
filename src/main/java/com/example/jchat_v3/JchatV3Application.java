package com.example.jchat_v3;

import com.example.jchat_v3.model.ChatUser;
import com.example.jchat_v3.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;


@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.example.jchat_v3")
@SpringBootApplication
public class JchatV3Application {

    @Autowired
    protected static ChatUserService chatUserService;

    public static void main(String[] args) {

        SpringApplication.run(JchatV3Application.class, args);
    }

}
