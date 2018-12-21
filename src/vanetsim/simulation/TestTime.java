package vanetsim.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestTime {

    int[] car = new int[4];
    int time_car;
    public TestTime(int i, int j, int time) {
//        car[j] = time;
        System.out.println("i: " + i + " j: " + j + " time: "+ time);

        //average time that i need for each of them to calculate from report item.
        /** for(i = 0; i < regions.length; ++i) {
            for (j = 0; j < regions[i].length; ++j) {
                vehicles = regions[i][j].getVehicleArray();
                for (k = 0; k < vehicles.length; ++k) {
                    vehicle = vehicles[k];
                    if (vehicle.getTotalTravelTime() > 0) {
                        ++travelledVehicles;
                        travelDistance += vehicle.getTotalTravelDistance();
                        travelTime += vehicle.getTotalTravelTime();
                    }
                }
            } */
        }
    }
    // Executor example in java.
    /*final ExecutorService executor = Executors.newFixedThreadPool(5); // it's just an arbitrary number
    final List<Future<?>> futures = new ArrayList<>();
    for (SellerNames sellerNames : sellerDataList) {
        for (final String sellerName : sellerNames) {
            Future<?> future = executor.submit(() -> {
                getSellerAddress(sellerName);
            });
            futures.add(future);
        }
    }
    try {
        for (Future<?> future : futures) {
            future.get(); // do anything you need, e.g. isDone(), ...
        }
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
    */

