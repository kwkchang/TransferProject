package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);



    }

    public void map1(Parent root,Scene scene, Stage primaryStage) {
        Scene map1 = new Scene(root, 1920, 1080);
        primaryStage.setScene(map1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
