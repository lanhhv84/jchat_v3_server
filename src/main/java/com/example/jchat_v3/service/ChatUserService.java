package com.example.jchat_v3.service;


import com.example.jchat_v3.db.ChatUserDB;
import com.example.jchat_v3.model.ChatUser;
import org.springframework.stereotype.Service;


@Service
public class ChatUserService extends IService<ChatUser, ChatUserDB>  {

    public ChatUser getUserByUsername(String username) {
        return super.db.getChatUserByUsername(username);
    }

    public boolean exists(String username) {
        return db.countByUserName(username) > 0;
    }
}
