package com.chatapplication.server;

import com.chatapplication.shared.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        Message msg = MessageReader.readMessageObj(socket.getInputStream());

    }
}
