package org.example.shared;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.util.Locale;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String country;
    private Locale.IsoCountryCode countryCode;

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
