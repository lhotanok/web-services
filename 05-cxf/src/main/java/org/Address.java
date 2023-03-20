package org;

public class Address {
	private String streetAddress;
    private String postalCode;
    private String city;
    private String country;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        // this.countryCode = FetchCountryCode(country);
        // this.postalCode = FetchPostalCode(city, country);
    }
}
