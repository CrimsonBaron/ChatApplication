module com.chatapplication.client.chatapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.chatapplication.client to javafx.fxml;
    exports com.chatapplication.client;
}