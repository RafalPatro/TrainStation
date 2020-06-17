package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import model.Position;
import model.Route;

import java.util.List;
import java.util.Random;

public class DrawRoutes {

    int scale;

    public DrawRoutes(int scale) {
        this.scale = scale;
    }

    public Group drawRoutes(Group root, List<Route> routes) {
        for (Route r : routes) {
            Paint paint = Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
            List<Position> positions1 = r.getPositionList();
            for (int i = 0; i < positions1.size() - 1; i++) {
                Line line1 = new Line(positions1.get(i).getPositionX() * scale, positions1.get(i).getPositionY() * scale, positions1.get(i + 1).getPositionX() * scale, positions1.get(i + 1).getPositionY() * scale);
                line1.setStroke(paint);
                line1.setStrokeWidth(10);
                root.getChildren().add(line1);
            }
            Line line1 = new Line(positions1.get(positions1.size() - 1).getPositionX() * scale, positions1.get(positions1.size() - 1).getPositionY() * scale, positions1.get(0).getPositionX() * scale, positions1.get(0).getPositionY() * scale);
            line1.setStroke(paint);
            line1.setStrokeWidth(10);
            root.getChildren().add(line1);
        }

        return root;
    }


}
