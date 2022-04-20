package com.chatapplication.client;

import com.chatapplication.shared.Message;
import com.chatapplication.shared.MessageReader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    @FXML
    private Button Button;

    @FXML
    private ListView<String> ListView;

    @FXML
    private TextField TextField;

    private Socket socket;


    public void onButtonClick() throws IOException {
        if (TextField.getText().isEmpty() || socket == null){
            return;
        }

        Message msg = new Message();
        msg.setCommand("SEND_MSG\n");
        msg.setData(TextField.getText());
        System.out.println(msg);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(msg);
        objectOutputStream.flush();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            socket = new Socket("localhost",8000);
            System.out.println("started client");
            Message msg = new Message();
            msg.setData("");
            msg.setCommand("START_USER");
            MessageReader.writeMessageObj(msg,socket.getOutputStream());


           ChatMsgListenerThread chatMsgListenerThread = new ChatMsgListenerThread(socket);
           chatMsgListenerThread.start();

            ListView.getItems().clear();
            ListView.getItems().addAll(ChatMsgListenerThread.MSG);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}