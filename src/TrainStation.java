import backend.Position;
import backend.Route;
import backend.Train;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TrainStation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        int scale = 50;
        Position trainStationPosition = new Position(12,8);
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(8,11));
        positions.add(new Position(8,8));
        positions.add(new Position(16,5));
        positions.add(new Position(9,10));
        List<Route> routes = initRoutes(trainStationPosition,positions);
        List<Train> trains = initTrains(routes,positions);
        backend.TrainStation.startTrains(trains);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

        for(Route r:routes){
            Paint paint = Color.rgb(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
            List<Position> positions1 = r.getPositionList();
            for(int i=0;i<positions1.size()-1;i++){
                Line line1 = new Line(positions1.get(i).getPositionX()*scale,positions1.get(i).getPositionY()*scale,positions1.get(i+1).getPositionX()*scale,positions1.get(i+1).getPositionY()*scale);
                line1.setStroke(paint);
                line1.setStrokeWidth(10);
                root.getChildren().add(line1);
            }
            Line line1 = new Line(positions1.get(positions1.size()-1).getPositionX()*scale,positions1.get(positions1.size()-1).getPositionY()*scale,positions1.get(0).getPositionX()*scale,positions1.get(0).getPositionY()*scale);
            line1.setStroke(paint);
            line1.setStrokeWidth(10);
            root.getChildren().add(line1);
        }

        Circle train1 = new Circle();
        train1.setCenterX(positions.get(0).getPositionX()*scale);
        train1.setCenterY(positions.get(0).getPositionY()*scale);
        train1.setRadius(20);
        train1.setFill(Color.rgb(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));


        Circle train2 = new Circle();
        train2.setCenterX(positions.get(1).getPositionX()*scale);
        train2.setCenterY(positions.get(1).getPositionY()*scale);
        train2.setRadius(20);
        train2.setFill(Color.rgb(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));



        Circle train3 = new Circle();
        train3.setCenterX(positions.get(2).getPositionX()*scale);
        train3.setCenterY(positions.get(2).getPositionY()*scale);
        train3.setRadius(20);
        train3.setFill(Color.rgb(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));


        Circle train4 = new Circle();
        train4.setCenterX(positions.get(3).getPositionX()*scale);
        train4.setCenterY(positions.get(3).getPositionY()*scale);
        train4.setRadius(20);
        train4.setFill(Color.rgb(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));

        List<Circle> trainsPo = new ArrayList<>();

        trainsPo.add(train1);
        trainsPo.add(train2);
        trainsPo.add(train3);
        trainsPo.add(train4);

        root.getChildren().add(train1);
        root.getChildren().add(train2);
        root.getChildren().add(train3);
        root.getChildren().add(train4);

        Runnable r = () -> {
            for(;;){
                for(int i =0 ;i< trains.size();i++){
                    trainsPo.get(i).setCenterX(trains.get(i).getPositionX()*scale);
                    trainsPo.get(i).setCenterY(trains.get(i).getPositionY()*scale);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread th = new Thread(r);

        th.start();




    }

    private List<Route> initRoutes(Position trainStationPosition, List<Position> initPositions) {

        List<Position> route1Positions = new ArrayList<>();
        route1Positions.add(trainStationPosition);
        route1Positions.add(initPositions.get(0));
        route1Positions.add(new Position(8,16));
        route1Positions.add(new Position(12,16));
        route1Positions.add(new Position(17,16));
        route1Positions.add(new Position(17,11));
        route1Positions.add(new Position(12,11));

        List<Position> route2Positions = new ArrayList<>();
        route2Positions.add(trainStationPosition);
        route2Positions.add(initPositions.get(1));
        route2Positions.add(new Position(6,11));
        route2Positions.add(new Position(4,9));
        route2Positions.add(new Position(3,13));
        route2Positions.add(new Position(0,8));
        route2Positions.add(new Position(2,5));
        route2Positions.add(new Position(6,5));
        route2Positions.add(new Position(8,2));
        route2Positions.add(new Position(12,5));

        List<Position> route3Positions = new ArrayList<>();
        route3Positions.add(trainStationPosition);
        route3Positions.add(initPositions.get(2));
        route3Positions.add(new Position(15,2));
        route3Positions.add(new Position(13,0));
        route3Positions.add(new Position(10,1));
        route3Positions.add(new Position(8,5));

        List<Position> route4Positions = new ArrayList<>();
        route4Positions.add(trainStationPosition);
        route4Positions.add(initPositions.get(3));
        route4Positions.add(new Position(14,10));
        route4Positions.add(new Position(17,12));
        route4Positions.add(new Position(20,12));
        route4Positions.add(new Position(23,10));
        route4Positions.add(new Position(23,7));
        route4Positions.add(new Position(20,6));
        route4Positions.add(new Position(18,9));
        route4Positions.add(new Position(14,9));

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


    public static void main(String[] args) {
        launch(args);
    }

    List<Train> initTrains(List<Route> routes, List<Position> initPositions){

        List<Train> trains = new ArrayList<>();
        trains.add(new Train(initPositions.get(0),routes.get(0)));
        trains.add(new Train(initPositions.get(1),routes.get(1)));
        trains.add(new Train(initPositions.get(2),routes.get(2)));
        trains.add(new Train(initPositions.get(3),routes.get(3)));

        return trains;
    }
















    }
