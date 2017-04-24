package sample;

import javafx.scene.Node;

import javafx.geometry.Point2D;

/**
 * Created by pwbla on 2017-04-24.
 */
public class Element {
    private Node view;
    private Point2D velocity = new Point2D(0, 0);
    public boolean status;


    public Element(Node view) {
        this.view = view;
    }

    public void updateLocation() {
        view.setTranslateX(view.getTranslateX() + velocity.getX() * 2);
        view.setTranslateY(view.getTranslateY() + velocity.getY() * 2);
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public Point2D getVelocity() {
        return velocity;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getRotate() {
        return view.getRotate();
    }

    public Node getView() {
        return view;
    }

    public void rotateRight() {
        view.setRotate(view.getRotate() + 10);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
    }

    public void rotateLeft() {
        view.setRotate(view.getRotate() - 10);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
    }

    public boolean isHitting(Element other) {
        return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
    }


}
