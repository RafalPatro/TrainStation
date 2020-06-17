package inits;

import model.Position;
import model.Route;
import model.Train;

import java.util.ArrayList;
import java.util.List;

public class TrainInit {

    private TrainInit() {
    }

    public static List<Train> initTrains(List<Route> routes, List<Position> initPositions) {

        List<Train> trains = new ArrayList<>();
        trains.add(new Train(initPositions.get(0), routes.get(0)));
        trains.add(new Train(initPositions.get(1), routes.get(1)));
        trains.add(new Train(initPositions.get(2), routes.get(2)));
        trains.add(new Train(initPositions.get(3), routes.get(3)));

        return trains;
    }

}
