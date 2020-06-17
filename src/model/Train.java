package model;

import view.DrawTrains;

import java.util.Random;

public class Train {

    private final Route route;
    private Position position;

    private final DrawTrains observer;

    public Train(Position initPosition, Route route, DrawTrains observer) {
        this.position = initPosition;
        this.route = route;
        this.observer = observer;
    }

    public void start() throws InterruptedException {
        for (; ; ) {
            Position p = route.getNextPosition(position);
            p.block();
            position.release();
            position = p;
            observer.update(this);
       /*     System.out.println(Thread.currentThread().getName() +
                    " actual position: \nX: " + position.getPositionX() + "\nY: " + position.getPositionY());*/
            Thread.sleep(new Random().nextInt(1000));
            if (position.isTrainStation()) {
                Thread.sleep(5000);
            }
        }
    }

    public double getPositionX() {
        return position.getPositionX();
    }


    public double getPositionY() {
        return position.getPositionY();
    }


}
