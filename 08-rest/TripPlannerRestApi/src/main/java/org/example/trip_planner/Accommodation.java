package org.example.trip_planner;

import org.example.shared.Address;

public class Accommodation {
    public boolean isBooked;
    public String name;
    public Address address;

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
