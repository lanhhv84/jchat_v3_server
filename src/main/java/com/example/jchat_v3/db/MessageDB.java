package com.example.jchat_v3.db;


import com.example.jchat_v3.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDB extends JpaRepository<Message, Integer> {
}
