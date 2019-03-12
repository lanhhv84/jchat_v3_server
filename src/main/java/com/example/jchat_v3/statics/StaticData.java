package com.example.jchat_v3.statics;

import com.example.jchat_v3.model.ChatUser;
import com.example.jchat_v3.model.UserInfo;

import java.util.HashSet;
import java.util.Set;

public class StaticData {
    public static Set<ChatUser> chatUsers = new HashSet<>();
    public static Set<UserInfo> online = new HashSet<>();
}
