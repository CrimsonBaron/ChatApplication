package com.chatapplication.server;

import com.chatapplication.shared.Message;
import com.chatapplication.shared.MessageReader;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MessageThread extends Thread {

    public static final List<Socket> CLIENTS = new ArrayList<>();

    private Socket socket;

    public MessageThread( Socket socket) {
        System.out.println("recived Socket: "+socket.toString());
        this.socket = socket;
    }

    @Override
    public void run() {
        synchronized (MessageReader.class){
            CLIENTS.add(socket);
           while (!socket.isClosed()){
               try {
                   Message msg = MessageReader.readMessageObj(socket.getInputStream());

                   if (msg != null){
                       for (Socket s: CLIENTS){
                           if (!s.isClosed() ) {
                               MessageReader.writeMessageObj(msg,s.getOutputStream());
                           }
                       }
                   }


               } catch (IOException e) {
                   e.printStackTrace();
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }

        }
    }
}
