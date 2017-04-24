package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

import java.io.IOException;
import java.util.ArrayList;

//Tank from http://piq.codeus.net/picture/85261/scorpion_tank

public class Main extends Application {

    public enum gameState {
        MAIN,
        MAP1,
        MAP2,
        MAP3
    }

    public static AnchorPane stage, map1p, map2p, map3p;
    public static Scene mainmenu;
    public static Scene map1, map2, map3;
    ArrayList<Element> bullets = new ArrayList<>();
    public static Tank player1;
    public static Tank player2;

    static Stage primaryStage;

    static class Tank extends Element {
        Tank() {
            super(new Rectangle(30,20,Color.BLUE));
        }

    }

    static class Bullet extends Element {
        Bullet() {
            super(new Circle(5, 5, 5, Color.BLACK));
        }
    }


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

        map1p.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT)
                player1.rotateLeft();
            if (e.getCode() == KeyCode.RIGHT)
                player1.rotateRight();
            if (e.getCode() == KeyCode.M) {
                Bullet bullet = new Bullet();
                bullet.setVelocity(player1.getVelocity().normalize().multiply(5));
                addBullet(bullet, player1.getView().getTranslateX(), player1.getView().getTranslateY());
            }
            if (e.getCode() == KeyCode.UP)
                player1.updateLocation(3.5);
            if (e.getCode() == KeyCode.DOWN)
                player1.setVelocity(player1.getVelocity().subtract(5, 5));
        });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

    }

    private static void addToGame(Element element, double x, double y) {
        element.getView().setTranslateX(x);
        element.getView().setTranslateY(y);
        map1p.getChildren().add(element.getView());
    }

    private void addBullet(Element element, double x, double y) {
        bullets.add(element);
        addToGame(element, x, y);
    }

    public void onUpdate() {
        for (Element bullet : bullets) {
            bullet.updateLocation(1);
            if (bullet.dead())
                map1p.getChildren().remove(bullet);
        }
    }

    public static void setGameState(gameState gameState) throws IOException {
        switch (gameState) {
            case MAIN:
                primaryStage.setScene(map1);
                break;
            case MAP1:
                primaryStage.setScene(map1);
                player1 = new Tank();
                addToGame(player1, 100, 100);
                break;
            case MAP2:

                break;
            case MAP3:
                break;
        }
    }

    public static void gameInit() {
        player1 = new Tank();
        player2 = new Tank();

    }

    public static void main(String[] args) {
        launch(args);
    }
}


