package view;


import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawTrains {

    int scale;
    List<Circle> trainsGUI;
    List<Train> trains;

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public void setTrainsGUI(List<Circle> trainsGUI) {
        this.trainsGUI = trainsGUI;
    }

    public DrawTrains(int scale) {
        this.scale = scale;
    }


    private double scaledPosition(double position) {
        return position * scale;
    }


    public List<Circle> drawTrainsInit(Group root, List<Train> trains) {

        List<Circle> trainCircles = new ArrayList<>();

        Image image = new Image("file:images/train.jpg");
        for (Train t : trains) {
            Circle c = new Circle();
            c.setCenterX(scaledPosition(t.getPositionX()));
            c.setCenterY(scaledPosition(t.getPositionY()));
            c.setRadius(20);
            c.setFill(new ImagePattern(image));
            c.setStroke(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            c.setStrokeWidth(3);
            trainCircles.add(c);
            root.getChildren().add(c);
        }

        return trainCircles;


    }


    public void update(Train t) {
        int i = trains.indexOf(t);
        Platform.runLater(() -> {
            trainsGUI.get(i).setCenterX(scaledPosition(t.getPositionX()));
            trainsGUI.get(i).setCenterY(scaledPosition(t.getPositionY()));
        });
    }
}
