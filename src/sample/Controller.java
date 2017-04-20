package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button startbtn;

    @FXML
    private Button exitbtn;

    @FXML
    void startOnAction(ActionEvent event) {
        Stage primaryStage = (Stage) startbtn.getScene().getWindow();
        primaryStage.setScene(new Scene(new Pane()));
    }

    @FXML
    void exitOnAction(ActionEvent event) {
        Platform.exit();
    }

}
