package com.chatapplication.client;

import com.chatapplication.shared.Message;
import com.chatapplication.shared.MessageReader;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatMsgListenerThread extends Thread {
    public static final List<String> MSG = new ArrayList<>();
    private Socket socket;
    private Message msg;

    public ChatMsgListenerThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
            synchronized (ChatMsgListenerThread.class){
                try {
                    while(socket.isConnected()){
                        msg= MessageReader.readMessageObj(socket.getInputStream());
                        System.out.println("recived msg:"+msg.toString());
                        MSG.add(msg.getData());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
    }

    public Message getMsg() {
        return msg;
    }
}
