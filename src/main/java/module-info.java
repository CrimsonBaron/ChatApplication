module com.chatapplication.client.chatapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.chatapplication.client to javafx.fxml;
    exports com.chatapplication.client;
}