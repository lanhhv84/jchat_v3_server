package com.example.jchat_v3.socket;

import com.example.jchat_v3.constant.SocketConstant;
import com.example.jchat_v3.model.ChatUser;
import com.example.jchat_v3.model.Message;
import com.example.jchat_v3.service.ChatUserService;
import com.example.jchat_v3.service.MessageService;
import com.google.gson.Gson;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class RelayServer extends Thread {

    Gson gson;
    ServerSocket serverSocket;
    HashMap<Integer, WriteReadThread> connectedSocket;
    ReentrantLock lock = new ReentrantLock();
    MessageService messageService;
    ChatUserService userService;

    public RelayServer(MessageService messageService) {
        gson = new Gson();
        try {
            serverSocket = new ServerSocket(SocketConstant.PORT);
        }
        catch (IOException ex) {

        }

    }

    @Override
    public void run() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            }
            catch (IOException ex) {

            }
            if (socket != null) {

                try {
                    InputStream inputStream = socket.getInputStream();
                    int userId = inputStream.read();
                    WriteReadThread writeReadThread = new WriteReadThread(socket, this::callBack);
                    connectedSocket.put(userId, writeReadThread);
                    writeReadThread.start();


                }
                catch (IOException ex) {
                    // TODO: Socket closed
                }

            }



        }

    }

    public ReceivedMessage callBack(Object object) {
        ReceivedMessage receivedMessage = gson.fromJson((String)object, ReceivedMessage.class);
        if (receivedMessage.isGroup()) {
            // TODO: Send to group
        }
        else {
            // Send to another user

            // Add to database
            Message message = new Message();
            message.setId(-1);
            message.setContent(receivedMessage.getContent());
            ChatUser sender = userService.findOne(receivedMessage.getSender());
            ChatUser receiver = userService.findOne(receivedMessage.getReceiver());
            message.setReceiver(receiver);
            message.setSender(sender);
            message.setSendTime(receivedMessage.getReceivedDate());
            messageService.add(message);


            // TODO: Send directly to user
            WriteReadThread pair = connectedSocket.get(receivedMessage.getReceiver());
            if (pair != null) {
                pair.getWriteThread().write(message);
            }
        }
        return null;
    }
}
