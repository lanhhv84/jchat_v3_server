package com.example.jchat_v3.controller;


import com.example.jchat_v3.model.ChatUser;
import com.example.jchat_v3.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    ChatUserService chatUserService;

    @RequestMapping(path = "/login")
    public ResponseEntity<?> login(@RequestParam("username") String username,
                                   @RequestParam("password") String password) {
        boolean resp = false;

        ChatUser chatUser = chatUserService.getUserByUsername(username);
        if (chatUser != null && chatUser.getPassword().equals(password)) {
            resp = true;
        }
        HashMap<String, Boolean> res = new HashMap<>();
        res.put("value", resp);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(path = "/add")
    public ResponseEntity<?> add(@RequestParam("username") String username,
                                 @RequestParam("password") String password) {
        Boolean value = false;
        ChatUser chatUser = chatUserService.getUserByUsername(username);
        if (chatUser != null) {
            value = false;
        }
        else {
            chatUser = new ChatUser();
            chatUser.setUsername(username);
            chatUser.setPassword(password);
            chatUserService.add(chatUser);
            value = true;
        }
        HashMap<String, Boolean> hashMap = new HashMap<>();
        hashMap.put("value", value);
        return ResponseEntity.ok(hashMap);
    }

    @RequestMapping(path = "/exist")
    public ResponseEntity<?> add(@RequestParam("username") String username) {
        return ResponseEntity.ok(chatUserService.exists(username));
    }

    @RequestMapping(path = "/group")
    public ResponseEntity<?> group(@RequestParam("username") String username) {
        ChatUser chatUser = chatUserService.getUserByUsername(username);
        return ResponseEntity.ok(chatUser.getGroups());
    }

    @RequestMapping(path = "/message/receive")
    public ResponseEntity<?> receiveMessage(@RequestParam("username") String username) {
        ChatUser chatUser = chatUserService.getUserByUsername(username);
        return ResponseEntity.ok(chatUser.getReceiveMessages());
    }

    @RequestMapping(path = "/message/send")
    public ResponseEntity<?> sendMessage(@RequestParam("username") String username) {
        ChatUser chatUser = chatUserService.getUserByUsername(username);
        return ResponseEntity.ok(chatUser.getSendMessages());
    }




}
