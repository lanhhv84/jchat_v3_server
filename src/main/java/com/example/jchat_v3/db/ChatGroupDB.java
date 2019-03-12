package com.example.jchat_v3.db;

import com.example.jchat_v3.model.ChatGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatGroupDB extends JpaRepository<ChatGroup, Integer> {
}
