package model;

public class Position {

    private final double positionX;

    private final double positionY;

    private boolean isBusy;

    private boolean isTrainStation = false;

    public Position(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Position(double positionX, double positionY, boolean isTrainStation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.isTrainStation = isTrainStation;
    }

    synchronized boolean isPositionBusy() {
        return isBusy;
    }

    synchronized boolean block() throws InterruptedException {
        while(isBusy) {
            //System.out.println(Thread.currentThread().getName() + " Waiting");
            wait();
           // System.out.println(Thread.currentThread().getName() + " Continue");
        }
        isBusy = true;
        return isBusy;
    }

    synchronized boolean release() {
        isBusy = false;
        notifyAll();
        return isBusy;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public boolean isTrainStation() {
        return isTrainStation;
    }
}
