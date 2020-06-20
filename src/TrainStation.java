import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Position;
import model.Route;
import model.Train;
import view.DrawRoutes;
import view.DrawTrains;

import java.util.List;

import static inits.PositionInit.initPositions;
import static inits.RouteInit.initRoutes;
import static inits.TrainInit.initTrains;


public class TrainStation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        int scale = 30;
        Position trainStationPosition = new Position(12, 8, true);
        DrawTrains dt = new DrawTrains(scale);

        List<Position> positions = initPositions();
        List<Route> routes = initRoutes(trainStationPosition, positions);
        List<Train> trains = initTrains(routes, positions, dt);
        dt.setTrains(trains);

        primaryStage.setTitle("Train Station");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

        DrawRoutes dr = new DrawRoutes(scale);
        dr.drawRoutes(root, routes);
        List<Circle> trainCircles = dt.drawTrainsInit(root, trains);
        dt.setTrainsGUI(trainCircles);
        controller.TrainStation.startTrains(trains);


    }


}
