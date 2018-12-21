package vanetsim.genetics;

import java16.util.ArrayDeque;
import org.codehaus.staxmate.SMOutputFactory;
import org.codehaus.staxmate.out.SMOutputDocument;
import org.codehaus.staxmate.out.SMOutputElement;
import vanetsim.ErrorLog;
import vanetsim.VanetSimStart;
import vanetsim.gui.Renderer;
import vanetsim.gui.helpers.AttackLogWriter;
import vanetsim.localization.Messages;
import vanetsim.map.Map;
import vanetsim.map.Node;
import vanetsim.map.Region;
import vanetsim.routing.WayPoint;
import vanetsim.scenario.AttackRSU;
import vanetsim.scenario.RSU;
import vanetsim.scenario.Scenario;
import vanetsim.scenario.Vehicle;
import vanetsim.scenario.events.Event;
import vanetsim.scenario.events.EventList;
import vanetsim.scenario.events.StartBlocking;
import vanetsim.scenario.events.StopBlocking;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class RandomCreator {
    public int[][] population = new int[8][8];
    ArrayList<Integer[][]> chromosome = new ArrayList<Integer[][]>();

    public ArrayList<HashMap> defineGens() {

        // define x & y.
        // give x[] one more same start poiit for more vechile.
        // make roads directionway visible at the end and show it with color on map.
        // make it with tehrans map.

        //2D start point.
        int[] x1 = new int[8];
        int[] y1 = new int[8];

        //2D destination.
        int[] x2 = new int[8];
        int[] y2 = new int[8];

        ArrayList<HashMap> chromosomes = new ArrayList<HashMap>();

        /** create an intial popultion */

        Population pop = new Population(5, true);

        /** create evalution */

        int gertationCount = 0;


        /** make vechile instead of xml use it in gerate Chromosome
        tmpVehicle = new Vehicle(destinations, vehicleLength, maxSpeed, maxCommDistance, wifi, emergencyVehicle, braking_rate, acceleration_rate, timeDistance, politeness, new Color(color));
        */

//        List<LatLong> latLongList = new ArrayList<LatLong>();
//
//
//
////
//                HashMap<Integer, Integer> chromosomeX = new HashMap<Integer, Integer>();
//                for(int j = 0; j < x1.length; j++) {
//
//                    // random without reaption;
//                    ArrayList<Integer> list = new ArrayList<Integer>(x1.length);
//                    for(int k = 0; k < x1.length; k++) {
//                        list.add(x1[k]);
//                    }
//
//                    Random rand = new Random();
//                    while(list.size() > 0) {
//                        int index = rand.nextInt(list.size());
//                        int destination = list.remove(index);
////                        x2[j] = x1[destination];
////                        y2[j] = y2[destination];
//                          double latitude = gps.getLatitude();
//                          double longitude = gps.getLongitude();
//                          latLongList.add(new LatLong(latitude, longitude));
////                        System.out.println("Selected: "+list.remove(index));
//                    }
//                    chromosomeX.put(x1[j], x2[j]);
//                }
//
//                chromosomes.add(chromosomeX);

    return chromosomes;
    }
    // use save in xml in Scanario class.
    // something that is static make them static and make another which is
    // dynamic like start point and end point change them.
    // make this part seprate in external class.

//    public void savetofile_genetic() {
//        try{
//            VanetSimStart.setProgressBar(true);
//            ErrorLog.log(Messages.getString("Scenario.savingScenario") + file.getName(), 3, getClass().getName(), "save", null);  //$NON-NLS-1$//$NON-NLS-2$
//            int i, j, k;
//            Vehicle[] vehiclesArray;
//            Node[] mixZoneArray;
//            ArrayDeque<WayPoint> destinations;
//            Iterator<WayPoint> wayPointIterator;
//            Vehicle vehicle;
//            Node mixNode;
//            WayPoint wayPoint;
//            RSU rsu;
//            RSU[] rsuArray;
//            Event event;
//            SMOutputElement level1, level2, level3;
//
//            int Region_cnt_x = Map.getInstance().getRegionCountX();
//            int Region_cnt_y = Map.getInstance().getRegionCountY();
//            Region[][] Regions = Map.getInstance().getRegions();
//
//            OutputStream filestream;
//            if(zip){
//                filestream = new ZipOutputStream(new FileOutputStream(file + ".zip")); //$NON-NLS-1$
//                ((ZipOutputStream) filestream).putNextEntry(new ZipEntry(file.getName()));
//            } else filestream = new FileOutputStream(file);
//            XMLStreamWriter xw = XMLOutputFactory.newInstance().createXMLStreamWriter(filestream);
//            SMOutputDocument doc = SMOutputFactory.createOutputDocument(xw);
//            doc.setIndentation("\n\t\t\t\t\t\t\t\t", 2, 1); ;  //$NON-NLS-1$
//            doc.addComment("Generated on " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date())); //$NON-NLS-1$ //$NON-NLS-2$
//
//            SMOutputElement root = doc.addElement("Scenario");			 //$NON-NLS-1$
//            SMOutputElement settings = root.addElement("Settings");			 //$NON-NLS-1$
//            settings.addElement("CommunicationEnabled").addValue(Vehicle.getCommunicationEnabled()); //$NON-NLS-1$
//            settings.addElement("BeaconsEnabled").addValue(Vehicle.getBeaconsEnabled()); //$NON-NLS-1$
//            settings.addElement("GlobalInfrastructureEnabled").addValue(true);	//$NON-NLS-1$
//            settings.addElement("CommunicationInterval").addValue(Vehicle.getCommunicationInterval()); //$NON-NLS-1$
//            settings.addElement("BeaconsInterval").addValue(Vehicle.getBeaconInterval()); //$NON-NLS-1$
//            settings.addElement("MixZonesEnabled").addValue(Vehicle.getMixZonesEnabled()); //$NON-NLS-1$
//            settings.addElement("MixZoneRadius").addValue(Vehicle.getMixZoneRadius()); //$NON-NLS-1$
//            settings.addElement("RoutingMode").addValue(Vehicle.getRoutingMode()); //$NON-NLS-1$
//            settings.addElement("VehicleRecyclingEnabled").addValue(Vehicle.getRecyclingEnabled()); //$NON-NLS-1$
//            settings.addElement("FallBackInMixZonesEnabled").addValue(Vehicle.getMixZonesFallbackEnabled());	//$NON-NLS-1$
//            settings.addElement("FallBackInMixZonesFloodingOnly").addValue(Vehicle.getMixZonesFallbackFloodingOnly());	//$NON-NLS-1$
//            settings.addElement("MinTravelTimeForRecycling").addValue(Vehicle.getMinTravelTimeForRecycling());	//$NON-NLS-1$
//
//            //arsu settings
//            settings.addElement("ARSULoggingEnabled").addValue(Vehicle.isAttackerDataLogged_());
//            settings.addElement("ARSULog").addCharacters(AttackLogWriter.getLogPath());	//$NON-NLS-1$
//            settings.addElement("ARSUEncryptedLoggingEnabled").addValue(Vehicle.isAttackerEncryptedDataLogged_());
//
//            //privacy log
//            settings.addElement("privacyLoggingEnabled").addValue(Vehicle.isPrivacyDataLogged_());
//
//            //silent period settings
//            settings.addElement("SilentPeriodsEnabled").addValue(Vehicle.isSilentPeriodsOn());
//            settings.addElement("SilentPeriodDuration").addValue(Vehicle.getTIME_OF_SILENT_PERIODS()); //$NON-NLS-1$
//            settings.addElement("SilentPeriodFrequency").addValue(Vehicle.getTIME_BETWEEN_SILENT_PERIODS()); //$NON-NLS-1$
//
//            if(RSU.isShowEncryptedBeaconsInMix_())settings.addElement("showEncryptedCommInMix").addCharacters("true");
//            else settings.addElement("showEncryptedCommInMix").addCharacters("false");
//            SMOutputElement vehicles = root.addElement("Vehicles");			 //$NON-NLS-1$
//
//            for(i = 0; i < Region_cnt_x; ++i){
//                for(j = 0; j < Region_cnt_y; ++j){
//                    vehiclesArray = Regions[i][j].getVehicleArray();
//                    for(k = 0; k < vehiclesArray.length; ++k){
//                        vehicle = vehiclesArray[k];
//                        level1 = vehicles.addElement("Vehicle"); //$NON-NLS-1$
//                        level1.addElement("VehicleLength").addValue(vehicle.getVehicleLength()); //$NON-NLS-1$
//                        level1.addElement("MaxSpeed").addValue(vehicle.getMaxSpeed()); //$NON-NLS-1$
//                        level1.addElement("MaxCommDist").addValue(vehicle.getMaxCommDistance()); //$NON-NLS-1$
//                        level1.addElement("Wifi").addValue(vehicle.isWiFiEnabled()); //$NON-NLS-1$
//                        level1.addElement("emergencyVehicle").addValue(vehicle.isEmergencyVehicle()); //$NON-NLS-1$
//                        level1.addElement("braking_rate").addValue(vehicle.getBrakingRate()); //$NON-NLS-1$
//                        level1.addElement("acceleration_rate").addValue(vehicle.getAccelerationRate()); //$NON-NLS-1$
//                        level1.addElement("timeDistance").addValue(vehicle.getTimeDistance()); //$NON-NLS-1$
//                        level1.addElement("politeness").addValue(vehicle.getPoliteness()); //$NON-NLS-1$
//                        level1.addElement("Color").addValue(vehicle.getColor().getRGB()); //$NON-NLS-1$
//                        if(Renderer.getInstance().getAttackerVehicle() == vehicle) level1.addElement("isAttacker").addValue(true); //$NON-NLS-1$
//                        else level1.addElement("isAttacker").addValue(false);
//                        if(Renderer.getInstance().getAttackedVehicle() == vehicle) level1.addElement("isAttacked").addValue(true); //$NON-NLS-1$
//                        else level1.addElement("isAttacked").addValue(false);
//                        level2 = level1.addElement("Destinations"); //$NON-NLS-1$
//                        //add the start point manually as this was already "popped" from the vehicle's destinations
//                        level3 = level2.addElement("WayPoint");	//$NON-NLS-1$
//                        level3.addElement("x").addValue(vehicle.getX());	//$NON-NLS-1$
//                        level3.addElement("y").addValue(vehicle.getY());	//$NON-NLS-1$
//                        level3.addElement("wait").addValue(vehicle.getWaittime());	//$NON-NLS-1$
//                        destinations = vehicle.getDestinations();
//                        wayPointIterator = destinations.iterator();	//iterate through destinations
//                        while(wayPointIterator.hasNext()){
//                            wayPoint = wayPointIterator.next();
//                            level3 = level2.addElement("WayPoint");	//$NON-NLS-1$
//                            level3.addElement("x").addValue(wayPoint.getX());	//$NON-NLS-1$
//                            level3.addElement("y").addValue(wayPoint.getY());	//$NON-NLS-1$
//                            level3.addElement("wait").addValue(wayPoint.getWaittime());	//$NON-NLS-1$
//                        }
//
//                    }
//                }
//            }
//
//            //save mix zones
//            SMOutputElement mixZones = root.addElement("MixZones");			 //$NON-NLS-1$
//
//            for(i = 0; i < Region_cnt_x; ++i){
//                for(j = 0; j < Region_cnt_y; ++j){
//                    mixZoneArray = Regions[i][j].getMixZoneNodes();
//                    for(k = 0; k < mixZoneArray.length; ++k){
//                        mixNode = mixZoneArray[k];
//                        level1 = mixZones.addElement("MixNode"); //$NON-NLS-1$
//                        level1.addElement("x").addValue(mixNode.getX()); //$NON-NLS-1$
//                        level1.addElement("y").addValue(mixNode.getY()); //$NON-NLS-1$
//                        level1.addElement("radius").addValue(mixNode.getMixZoneRadius()); //$NON-NLS-1$
//                        if(mixNode.getEncryptedRSU_() != null) level1.addElement("hasRSU").addValue(true); //$NON-NLS-1$
//                        else level1.addElement("hasRSU").addValue(false); //$NON-NLS-1$
//
//                    }
//                }
//            }
//
//            //save rsus
//            SMOutputElement rsus = root.addElement("RSUs");			 //$NON-NLS-1$
//
//            for(i = 0; i < Region_cnt_x; ++i){
//                for(j = 0; j < Region_cnt_y; ++j){
//                    rsuArray = Regions[i][j].getRSUs();
//                    for(k = 0; k < rsuArray.length; ++k){
//                        rsu = rsuArray[k];
//                        if(!rsu.isEncrypted_()){
//                            level1 = rsus.addElement("RSU"); //$NON-NLS-1$
//                            level1.addElement("x").addValue(rsu.getX()); //$NON-NLS-1$
//                            level1.addElement("y").addValue(rsu.getY()); //$NON-NLS-1$
//                            level1.addElement("radius").addValue(rsu.getWifiRadius()); //$NON-NLS-1$
//                            level1.addElement("isEncrypted").addValue(rsu.isEncrypted_()); //$NON-NLS-1$
//                        }
//                    }
//                }
//            }
//
//            //save arsus
//            SMOutputElement arsus = root.addElement("ARSUs");			 //$NON-NLS-1$
//
//            AttackRSU[] tempARSUList = Vehicle.getArsuList();
//
//            for(int l = 0; l < tempARSUList.length;l++) {
//                level1 = arsus.addElement("ARSU"); //$NON-NLS-1$
//                level1.addElement("x").addValue(tempARSUList[l].getX()); //$NON-NLS-1$
//                level1.addElement("y").addValue(tempARSUList[l].getY()); //$NON-NLS-1$
//                level1.addElement("radius").addValue(tempARSUList[l].getWifiRadius()); //$NON-NLS-1$
//            }
//
//
//            SMOutputElement events = root.addElement("Events");			 //$NON-NLS-1$
//            Iterator<Event> eventIterator = EventList.getInstance().getIterator();
//            while(eventIterator.hasNext()){
//                event = eventIterator.next();
//                level1 = events.addElement("Event"); //$NON-NLS-1$
//                level1.addElement("Time").addValue(event.getTime()); //$NON-NLS-1$
//                if(event.getClass() == StartBlocking.class){
//                    level1.addElement("Type").addCharacters("startBlocking"); //$NON-NLS-1$ //$NON-NLS-2$
//                    level1.addElement("x").addValue(((StartBlocking)event).getX()); //$NON-NLS-1$
//                    level1.addElement("y").addValue(((StartBlocking)event).getY()); //$NON-NLS-1$
//                    level1.addElement("Direction").addValue(((StartBlocking)event).getAffectedDirection()); //$NON-NLS-1$
//                    level1.addElement("Lanes").addValue(((StartBlocking)event).getAffectedLanes()); //$NON-NLS-1$
//                } else if(event.getClass() == StopBlocking.class) {
//                    level1.addElement("Type").addCharacters("stopBlocking"); //$NON-NLS-1$ //$NON-NLS-2$
//                    level1.addElement("x").addValue(((StopBlocking)event).getX()); //$NON-NLS-1$
//                    level1.addElement("y").addValue(((StopBlocking)event).getY()); //$NON-NLS-1$
//                } else ErrorLog.log(Messages.getString("Scenario.unknownEvent"), 6, getClass().getName(), "save", null); //$NON-NLS-1$ //$NON-NLS-2$
//            }
//            doc.closeRoot();
//            xw.close();
//            filestream.close();
//        }catch (Exception e) { ErrorLog.log(Messages.getString("Scenario.errorWhileSaving"), 6, getClass().getName(), "save", e);} //$NON-NLS-1$ //$NON-NLS-2$
//        VanetSimStart.setProgressBar(false);
//
//    }
//
//
//
//
//    // start from new xml not the same one.
//    //pass
//
//    // getting time when its finesde and run new Scanrio.
//    //pass
}


