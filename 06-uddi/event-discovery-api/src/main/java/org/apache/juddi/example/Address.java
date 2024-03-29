package org.apache.juddi.example;

import java.util.Locale;

public class Address {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String country;
    private Locale locale;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        // this.countryCode = FetchCountryCode(country);
        // this.postalCode = FetchPostalCode(city, country);
    }

    public Address(String streetAddress, String city, Locale locale) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.locale = locale;
        // this.country = FetchCountryName(countryCode);
        // this.postalCode = FetchPostalCode(city, countryCode);
    }
}
