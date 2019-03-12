package com.example.jchat_v3;

import com.example.jchat_v3.service.MessageService;
import com.example.jchat_v3.socket.RelayServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.example.jchat_v3")
@SpringBootApplication
@Component
public class Main implements CommandLineRunner {

    @Autowired
    MessageService messageService;

    @Override
    public void run(String ... argv) throws Exception {
        RelayServer relayServer = new RelayServer(messageService);
        relayServer.start();
    }
}
