package controller;

import model.Train;

import java.util.List;

public class TrainStation {
    private TrainStation() {
    }

    public static void startTrains(List<Train> trains) {

        for (Train t : trains) {
            Runnable r = () -> {
                try {
                    t.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            };
            Thread th = new Thread(r);
            th.start();
        }
    }


}
