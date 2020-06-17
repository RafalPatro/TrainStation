package inits;

import model.Position;
import model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteInit {

    private RouteInit() {
    }

    public static List<Route> initRoutes(Position trainStationPosition, List<Position> initPositions) {

        List<Position> route1Positions = new ArrayList<>();
        route1Positions.add(trainStationPosition);
        route1Positions.add(initPositions.get(0));
        route1Positions.add(new Position(8, 16));
        route1Positions.add(new Position(12, 16));
        route1Positions.add(new Position(17, 16));
        route1Positions.add(new Position(17, 11));
        route1Positions.add(new Position(12, 11));

        List<Position> route2Positions = new ArrayList<>();
        route2Positions.add(trainStationPosition);
        route2Positions.add(initPositions.get(1));
        route2Positions.add(new Position(6, 11));
        route2Positions.add(new Position(4, 9));
        route2Positions.add(new Position(3, 13));
        route2Positions.add(new Position(0, 8));
        route2Positions.add(new Position(2, 5));
        route2Positions.add(new Position(6, 5));
        route2Positions.add(new Position(8, 2));
        route2Positions.add(new Position(12, 5));

        List<Position> route3Positions = new ArrayList<>();
        route3Positions.add(trainStationPosition);
        route3Positions.add(initPositions.get(2));
        route3Positions.add(new Position(15, 2));
        route3Positions.add(new Position(13, 0));
        route3Positions.add(new Position(10, 1));
        route3Positions.add(new Position(8, 5));

        List<Position> route4Positions = new ArrayList<>();
        route4Positions.add(trainStationPosition);
        route4Positions.add(initPositions.get(3));
        route4Positions.add(new Position(14, 10));
        route4Positions.add(new Position(17, 12));
        route4Positions.add(new Position(20, 12));
        route4Positions.add(new Position(23, 10));
        route4Positions.add(new Position(23, 7));
        route4Positions.add(new Position(20, 6));
        route4Positions.add(new Position(18, 9));
        route4Positions.add(new Position(14, 9));

        Route route1 = new Route(route1Positions);
        Route route2 = new Route(route2Positions);
        Route route3 = new Route(route3Positions);
        Route route4 = new Route(route4Positions);

        List<Route> routes = new ArrayList<>();
        routes.add(route1);
        routes.add(route2);
        routes.add(route3);
        routes.add(route4);
        return routes;
    }


}
