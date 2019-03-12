package com.example.jchat_v3.service;

import com.example.jchat_v3.db.MessageDB;
import com.example.jchat_v3.model.Message;
import org.springframework.stereotype.Service;


@Service
public class MessageService extends IService<Message, MessageDB>  {
}
