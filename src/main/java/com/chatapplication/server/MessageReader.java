package com.chatapplication.server;

import com.chatapplication.shared.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MessageReader {
    public static Message readMessageObj(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (Message) objectInputStream.readObject();
    }
}
