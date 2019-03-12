package com.example.jchat_v3.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class WriteThread {

    ObjectOutputStream writer;

    public WriteThread(OutputStream outputStream) throws IOException{
        this.writer = new ObjectOutputStream(outputStream);
    }

    public void write(Object next){
        Thread thread = new Thread(() -> {
            try {
                writer.writeObject(next);
                writer.flush();
            }
            catch (IOException ex) {

            }

        });
        thread.start();

    }
}
