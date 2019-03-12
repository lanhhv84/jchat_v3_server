package com.example.jchat_v3.db;

import com.example.jchat_v3.model.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMessageDB extends JpaRepository<GroupMessage, Integer> {
}
