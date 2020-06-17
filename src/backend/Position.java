package backend;

public class Position {

    private final double positionX;

    private final double positionY;

    private boolean isBusy;

    public Position(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    synchronized boolean isPositionBusy(){
        return isBusy;
    }

    synchronized boolean block() throws InterruptedException {
        if(isBusy){
            wait();
        }
        isBusy = true;
        return isBusy;
    }

    synchronized boolean release(){
        isBusy = false;
        notifyAll();
        return isBusy;
    }

    public double getPositionX(){
        return positionX;
    }

    public double getPositionY(){
        return positionY;
    }



}
