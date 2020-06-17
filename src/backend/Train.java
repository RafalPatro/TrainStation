package backend;

import java.util.Random;

public class Train {

    private Position position;
    private final Route route;

    public Train(Position initPosition, Route route) {
        this.position = initPosition;
        this.route = route;
    }

    public void start() throws InterruptedException {
        for( ; ; ){
            Position p = route.getNextPosition(position);
            p.block();
            position.release();
            position = p;
            System.out.println(Thread.currentThread().getName() +
                    " actual position: \nX: " + position.getPositionX() + "\nY: " + position.getPositionY());
            Thread.sleep(new Random().nextInt(1000));
            }
    }

    public double getPositionX(){
        return position.getPositionX();
    }


    public double getPositionY(){
        return position.getPositionY();
    }


}
