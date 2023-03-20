package org;

import java.util.Date;
import java.util.UUID;

public class Trip {
	private String uuid;
    private String name;
    private Date dateFrom;
    private Date dateTo;
    private String locationCity;
    private String locationCountry;
    private Accommodation accommodation;
    
    public Trip() {}
    public Trip(String name) {
        this.name = name;
        this.uuid = UUID.nameUUIDFromBytes(name.getBytes()).toString();
    }

    public Trip(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public String id() {
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
