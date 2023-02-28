package org.example.trip_planner;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Accommodation {
    private boolean isBooked;
    private String name;
    private Address address;

    public Accommodation(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public boolean isBooked() {
        return this.isBooked;
    }

    public String name() {
        return this.name;
    }

    public Address address() {
        return this.address;
    }

    public Accommodation setName(String name) {
        this.name = name;
        return this;
    }

    public Accommodation setAddress(Address address) {
        this.address = address;
        return this;
    }
}
