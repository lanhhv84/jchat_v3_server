package com.example.jchat_v3.db;

import com.example.jchat_v3.model.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserDB extends JpaRepository<ChatUser, Integer> {
}
