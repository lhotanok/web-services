package org.example.trip_planner;

import jakarta.xml.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Trip {
    private final UUID uuid;
    private final String name;
    private Date dateFrom;
    private Date dateTo;
    private String locationCity;
    private String locationCountry;
    private Accommodation accommodation;
    public Trip(String name) {
        this.name = name;
        this.uuid = UUID.nameUUIDFromBytes(name.getBytes());
    }

    public Trip(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public UUID id() {
        return this.uuid;
    }

    public String name() {
        return this.name;
    }

    public Accommodation accommodationInfo() {
        return this.accommodation;
    }

    public String city() {
        return this.locationCity;
    }

    public String country() {
        return this.locationCountry;
    }

    public Date from() {
        return this.dateFrom;
    }

    public Date to() {
        return this.dateTo;
    }

    public Trip setDate(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        return this;
    }

    public Trip setLocation(String locationCity, String locationCountry) {
        this.locationCity = locationCity;
        this.locationCountry = locationCountry;
        return this;
    }

    public Trip setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
        return this;
    }
}
