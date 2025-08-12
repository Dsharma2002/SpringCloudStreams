package com.demo.consumer;

public class RiderLocation {

    private String riderId;
    private double latitude;
    private double longitude;

    public RiderLocation(String string, double d, double e) {
        this.riderId = string;
        this.latitude = d;
        this.longitude = e;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

}
