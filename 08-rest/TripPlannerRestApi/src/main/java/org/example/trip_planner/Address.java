package org.example.trip_planner;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Locale;

@XmlRootElement
public class Address {
    public String streetAddress;
    public String postalCode;
    public String city;
    public String country;
    public Locale.IsoCountryCode countryCode;
    public Address(){}

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        // this.countryCode = FetchCountryCode(country);
        // this.postalCode = FetchPostalCode(city, country);
    }

    public Address(String streetAddress, String city, Locale.IsoCountryCode countryCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.countryCode = countryCode;
        // this.country = FetchCountryName(countryCode);
        // this.postalCode = FetchPostalCode(city, countryCode);
    }
}
