package org.apache.juddi.example;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Event {
    private final UUID uuid;
    private double latitude;
    private double longitude;
    private String geohash;
    private Address address;
    private String name;

    private ZonedDateTime dateTimeFrom;
    private ZonedDateTime dateTimeTo;

    public Event(String name) {
        this.name = name;
        this.uuid = UUID.nameUUIDFromBytes(name.getBytes());
    }

    public Event(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public double latitude() {
        return this.latitude;
    }
    public double longitude(){
        return this.longitude;
    }
    public String geohash(){
        return this.geohash;
    }
    public Address address(){
        return this.address;
    }
    public String name(){
        return this.name;
    }

    public ZonedDateTime from() {
        return dateTimeFrom;
    }

    public ZonedDateTime to() {
        return dateTimeTo;
    }

    public Event setLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

        // this.geohash = calculateGeohash(latitude, longitude);

        return this;
    }

    public Event setLocation(String geohash) {
        this.geohash = geohash;

        // this.latitude = calculateLatitude(geohash);
        // this.longitude = calculateLongitude(geohash);

        return this;
    }

    public Event setAddress(Address address) {
        this.address = address;
        return this;
    }
}
