package vanetsim.genetics;

public class LatLong {
    double latitude;
    double longitude;

    public LatLong(double lat, double longitude) {
        this.latitude = lat;
        this.longitude = longitude;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }
}