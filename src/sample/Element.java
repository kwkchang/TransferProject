package sample;

import java.awt.geom.Point2D;
import javafx.scene.Node

public class Element {

    private Node view;
    private Point2D velocity;

    boolean alive = true;

    public Element(Node view) {
        this.view = view;
    }


}
