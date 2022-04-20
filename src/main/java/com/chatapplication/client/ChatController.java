package com.chatapplication.client;

import com.chatapplication.shared.Message;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatController {
    @FXML
    public Button Button;
    public javafx.scene.control.ListView ListView;
    public javafx.scene.control.TextField TextField;
    private Label welcomeText;


    Message message = new Message();

    public void onButtonClick() {
        message.setData(TextField.getAccessibleText());
    }


}