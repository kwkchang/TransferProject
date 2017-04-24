package sample;

import javafx.scene.Node;

import javafx.geometry.Point2D;

/**
 * Created by pwbla on 2017-04-24.
 */
public class Element {
    private Node view;
    private Point2D velocity = new Point2D(0, 0);

    public Element(Node view) {
        this.view = view;
    }

    public void updateLocation() {
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
        System.out.println(view + " location updated");
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }


}
