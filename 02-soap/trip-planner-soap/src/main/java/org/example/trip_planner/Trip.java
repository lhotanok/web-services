package org.example.trip_planner;

import jakarta.xml.bind.annotation.*;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.Date;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Trip {
    private final UUID uuid;
    private String name;
    private Date dateFrom;
    private Date dateTo;
    private String duration;
    private String locationCity;
    private String locationCountry;

    private double latitude;
    private double longitude;
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

        this.duration = DurationFormatUtils.formatPeriodISO(
                dateFrom.getTime(), dateTo.getTime()
        );
        return this;
    }

    public Trip setLocation(String locationCity, String locationCountry) {
        this.locationCity = locationCity;
        this.locationCountry = locationCountry;

        this.latitude = 41.902782; // dummy latitude (Rome)
        this.longitude = 12.496366; // dummy longitude (Rome)
        return this;
    }

    public Trip setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
        return this;
    }
}
