package com.chatapplication.shared;

import com.chatapplication.shared.Message;

import java.io.*;

public class MessageReader {




    public static Message readMessageObj(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (Message) objectInputStream.readObject();
    }

    public static void writeMessageObj(Message msg, OutputStream outputStream) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(msg);
        objectOutputStream.flush();
    }
}
