package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public enum gameState {
        MAIN,
        MAP1,
        MAP2,
        MAP3
    }
    public static Parent stage, map1p, map2p, map3p;
    public static Scene mainmenu;
    public static Scene map1, map2, map3;


    static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainmenu = new Scene(stage, 400, 400);
        primaryStage.setScene(mainmenu);
        primaryStage.show();
        primaryStage.setResizable(false);
        this.primaryStage = primaryStage;
        map1p = FXMLLoader.load(getClass().getResource("map1.fxml"));
        map1 = new Scene(map1p, 600, 400);

    }

    public static void setGameState(gameState gameState) throws IOException {
        switch (gameState) {
            case MAIN:
                primaryStage.setScene(map1);
                break;

            case MAP1:
                primaryStage.setScene(map1);
                break;
            case MAP2:

                break;
            case MAP3:
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
