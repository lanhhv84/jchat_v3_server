package com.example.jchat_v3.db;

import com.example.jchat_v3.model.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatUserDB extends JpaRepository<ChatUser, Integer> {
    @Query(value = "SELECT * FROM user_data WHERE u_username = ?1", nativeQuery = true)
    ChatUser getChatUserByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM user_data WHERE u_username = ?!", nativeQuery = true)
    int countByUserName(String username);
}
