package com.example.jchat_v3.controller;


import com.example.jchat_v3.model.ChatUser;
import com.example.jchat_v3.model.UserInfo;
import com.example.jchat_v3.service.ChatUserService;
import com.example.jchat_v3.statics.StaticData;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(path = "/user")
public class UserController extends BaseController {

    @Autowired
    ChatUserService chatUserService;

    Gson gson = new Gson();

    @RequestMapping(path = "/login")
    public ResponseEntity<?> login(@RequestParam("username") String username,
                                   @RequestParam("password") String password) {

        ChatUser chatUser = chatUserService.getUserByUsername(username);
        if (chatUser != null && chatUser.getPassword().equals(password)) {
            StaticData.chatUsers.add(chatUser);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(chatUser.getId());
            userInfo.setNickName(chatUser.getNickName());
            StaticData.online.add(userInfo);
            return ok(gson.toJson(userInfo));
        }
        else {
            return ok(null);
        }

    }

    @RequestMapping(path = "/add")
    public ResponseEntity<?> add(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("nickname") String nickname) {
        Boolean value = false;
        ChatUser chatUser = chatUserService.getUserByUsername(username);
        if (chatUser != null) {
            value = false;
        }
        else {
            chatUser = new ChatUser();
            chatUser.setUsername(username);
            chatUser.setPassword(password);
            chatUser.setNickName(nickname);
            chatUserService.add(chatUser);
            value = true;
        }
        return ok(value);
    }

    @RequestMapping(path = "/exist")
    public ResponseEntity<?> add(@RequestParam("username") String username) {
        return ResponseEntity.ok(chatUserService.exists(username));
    }

    @RequestMapping(path = "/group")
    public ResponseEntity<?> group(@RequestParam("username") String username) {
        ChatUser chatUser = chatUserService.getUserByUsername(username);
        return ok(chatUser.getGroups());
    }

    @RequestMapping(path = "/message/receive")
    public ResponseEntity<?> receiveMessage(@RequestParam("username") String username) {
        ChatUser chatUser = chatUserService.getUserByUsername(username);
        return ok(chatUser.getReceiveMessages());
    }

    @RequestMapping(path = "/message/send")
    public ResponseEntity<?> sendMessage(@RequestParam("username") String username) {
        ChatUser chatUser = chatUserService.getUserByUsername(username);
        return ok(chatUser.getSendMessages());
    }


    @RequestMapping(path = "/online")
    public ResponseEntity<?> online() {
        return ok(gson.toJson(StaticData.online));
    }






}
