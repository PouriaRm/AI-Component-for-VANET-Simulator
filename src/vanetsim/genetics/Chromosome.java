package vanetsim.genetics;

import java16.util.ArrayDeque;
import vanetsim.gui.Renderer;
import vanetsim.map.Map;
import vanetsim.routing.WayPoint;
import vanetsim.scenario.RSU;
import vanetsim.scenario.Vehicle;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Chromosome {
    static int defaultGeneLength = 8;
    private double[] genes = new double[defaultGeneLength];
    List<LatLong> latLongList = new ArrayList<LatLong>();
    // Cache
    private int fitness = 0;


    int[] x1 = new int[]{631140,121440,372602,588018,728546,354675,775712,82803};
    int[] y1 = new int[]{152269,545820,152456,101842,91124,111015,322700,307978};

    //2D destination.
    int[] x2 = new int[]{631140,121440,372602,588018,728546,354675,775712,82803};
    int[] y2 = new int[]{152269,545820,152456,101842,91124,111015,322700,307978};
    int carNumber = 2;

    ArrayDeque<WayPoint> destinations;
    Vehicle tmpVehicle;
    WayPoint tmpWayPoint;
    int x, y, time, maxSpeed, vehicleLength, maxCommDistance, direction, lanes, braking_rate, acceleration_rate, timeDistance, politeness, color, mixX, mixY, mixRadius, wifiX, wifiY, wifiRadius;
    boolean tmpBoolean, wifi, emergencyVehicle, tmpAttacker, tmpAttacked, isEncrypted, mixHasRSU;




    // Create a random individual
    public void generateIndividual(int chromosome) {


            maxCommDistance = 10000;
            vehicleLength = 2500;
            maxSpeed = 10000;
            wifi = true;
            emergencyVehicle = false;
            braking_rate = 100;
            acceleration_rate = 200;
            timeDistance = 100;
            politeness = 50;
            color = 0;


            tmpAttacker = false;
            tmpAttacked = false;



            tmpBoolean = true;
            Vehicle.setCommunicationEnabled(tmpBoolean);
            RSU.setCommunicationEnabled(tmpBoolean);

            Vehicle.setBeaconsEnabled(tmpBoolean);
            RSU.setBeaconsEnabled(tmpBoolean);
            Vehicle.setMixZonesEnabled(tmpBoolean);

            Vehicle.setMixZonesFallbackEnabled(tmpBoolean);

            Vehicle.setCommunicationInterval(160);
            RSU.setCommunicationInterval(160);

            Vehicle.setBeaconInterval(240);
            RSU.setBeaconInterval(240);

            Vehicle.setMixZoneRadius(10000);

            Vehicle.setRoutingMode(1);

            Vehicle.setMinTravelTimeForRecycling(60000);
            Vehicle.setRecyclingEnabled(false);
            Vehicle.setPrivacyDataLogged_(false);
            Vehicle.setSilentPeriodsOn(false);

            Vehicle.setTIME_BETWEEN_SILENT_PERIODS(10000);
            Vehicle.setTIME_OF_SILENT_PERIODS(2000);

            vehicleLength=600;
            maxSpeed=4786;
            maxCommDistance=10000;
            wifi=true;
            emergencyVehicle=true;
            braking_rate=800;
            acceleration_rate=300;
            timeDistance=101;
            politeness=10;
            color=-16777216;
            tmpAttacked=false;
            tmpAttacker=false;



                // random without reaption;
                ArrayList<Integer> list = new ArrayList<Integer>(x1.length);
                for(int k = 0; k < x1.length; k++) {
                    list.add(x1[k]);
                }

                Random rand = new Random();
                int vehichleNumber=0;
                while(list.size() > 0) {
                    destinations = new ArrayDeque<WayPoint>(1);
                    int index = rand.nextInt(list.size());
                    int destination = list.remove(index);

//                        x2[j] = x1[destination];
//                        y2[j] = y2[destination];
                    double latitude1 = x1[index];
                    double longitude1 = y1[index];

                    double latitude2 = x2[list.size()];
                    double longitude2 = y2[list.size()];
                    int time = 10;

                    vehichleNumber++;
                    if (vehichleNumber < 3) {
                        int startpoint = rand.nextInt(x1.length);
                        // define startpoint by each number of vehichles.
                        x2[startpoint] = 19783;
                        y2[startpoint] = 56304;
                    }


                    try {
                        tmpWayPoint = new WayPoint(x2[index], y2[index], time);
                        destinations.add(tmpWayPoint);

                        System.out.println("Hello: " + chromosome);

                        tmpWayPoint = new WayPoint(x1[list.size()], y1[list.size()], time);
                        destinations.add(tmpWayPoint);


                    } catch (ParseException e) {

                    }

                    if (maxCommDistance != -1 && maxSpeed != -1 && destinations.size() > 1) {
                        try {
                            tmpVehicle = new Vehicle(destinations, vehicleLength, maxSpeed, maxCommDistance, wifi, emergencyVehicle, braking_rate, acceleration_rate, timeDistance, politeness, new Color(color));

                            System.err.println("desto: "+ tmpVehicle.getDestinations().size());
                            /** setChrmose for define which chromosome are be. */

                            tmpVehicle.setChromosome(chromosome);
                            Map.getInstance().addVehicle(tmpVehicle);
                            if (tmpAttacker) Renderer.getInstance().setAttackerVehicle(tmpVehicle);
                            if (tmpAttacked) {
                                Renderer.getInstance().setAttackedVehicle(tmpVehicle);
                                Vehicle.setAttackedVehicleID_(tmpVehicle.getID());
                            }
                            tmpAttacker = false;
                            tmpAttacked = false;
                        } catch (Exception e) {
                        }

//                        System.out.println("Selected: "+list.remove(index));
                    }

                }

    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }

    public int getGene(int index) {
        return x2[index];
    }

    public void setGene(int index, int value) {
        x2[index] = value;
        fitness = 0;
    }

    /* Public methods */
    public int size() {
        return x1.length;
    }

    public int getFitness() {
        if (fitness == 0) {
//            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }


}


