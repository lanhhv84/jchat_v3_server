package com.example.jchat_v3.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.function.UnaryOperator;

public class WriteReadThread {

    ReadThread readThread;
    WriteThread writeThread;

    public WriteReadThread(Socket socket, UnaryOperator<Object> receiveCallback) throws IOException {
        writeThread = new WriteThread(socket.getOutputStream());
        readThread = new ReadThread(socket.getInputStream(), receiveCallback);
    }

    public void start() {
        readThread.start();
    }

    public ReadThread getReadThread() {
        return readThread;
    }

    public void setReadThread(ReadThread readThread) {
        this.readThread = readThread;
    }

    public WriteThread getWriteThread() {
        return writeThread;
    }

    public void setWriteThread(WriteThread writeThread) {
        this.writeThread = writeThread;
    }
}
