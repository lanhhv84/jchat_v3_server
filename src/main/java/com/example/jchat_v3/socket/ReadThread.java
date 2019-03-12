package com.example.jchat_v3.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ReadThread extends Thread {

    ObjectInputStream reader;
    UnaryOperator<Object> callBack;

    public ReadThread(InputStream inputStream, UnaryOperator<Object> callBack) throws IOException {
        this.reader = new ObjectInputStream(inputStream);
        this.callBack = callBack;
    }

    @Override
    public void run() {
        System.out.println("Start to read");
        while (true) {
            try {
                callBack.apply(reader.readObject());


            }
            catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex);
            }


        }
    }
}
