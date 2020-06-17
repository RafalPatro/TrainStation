package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawTrains {

    int scale;

    public DrawTrains(int scale) {
        this.scale = scale;
    }

    private double scaledPosition(double position) {
        return position * scale;
    }


    public List<Circle> drawTrainsInit(Group root, List<Train> trains) {

        List<Circle> trainCircles = new ArrayList<>();

        for (Train t : trains) {
            Circle c = new Circle();
            c.setCenterX(scaledPosition(t.getPositionX()));
            c.setCenterY(scaledPosition(t.getPositionY()));
            c.setRadius(20);
            c.setFill(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            trainCircles.add(c);
            root.getChildren().add(c);
        }

        return trainCircles;


    }

    public void drawActualPosition(List<Train> trains, List<Circle> circles) {
        Runnable r = () -> {
            for (; ; ) {
                for (int i = 0; i < trains.size(); i++) {
                    circles.get(i).setCenterX(trains.get(i).getPositionX() * scale);
                    circles.get(i).setCenterY(trains.get(i).getPositionY() * scale);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread th = new Thread(r);

        th.start();

    }
}
