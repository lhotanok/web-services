package org.example.trip_planner;

import jakarta.jws.WebParam;
import org.example.planned_items.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@jakarta.jws.WebService
public interface ITripPlanner {
    @jakarta.jws.WebMethod
    List<Trip> viewMyTrips();

    @jakarta.jws.WebMethod
    List<PlanItem> viewMyPlannedItems();

    @jakarta.jws.WebMethod
    Calendar planMyTrip();

    @jakarta.jws.WebMethod
    void savePlaceItem(
            @WebParam(name = "id", targetNamespace = "http://trip_planner.example.org/") UUID uuid,
            @WebParam(name = "lat", targetNamespace = "http://trip_planner.example.org/") double latitude,
            @WebParam(name = "long", targetNamespace = "http://trip_planner.example.org/") double longitude
    );

    @jakarta.jws.WebMethod
    void saveEventItem(
            @WebParam(name = "id", targetNamespace = "http://trip_planner.example.org/") UUID uuid,
            @WebParam(name = "lat", targetNamespace = "http://trip_planner.example.org/") double latitude,
            @WebParam(name = "long", targetNamespace = "http://trip_planner.example.org/") double longitude
    );

    @jakarta.jws.WebMethod
    Trip getOrCreate(
            @WebParam(name = "tripName", targetNamespace = "http://trip_planner.example.org/") String tripName
    );

    @jakarta.jws.WebMethod
    Trip setDate(
            @WebParam(name = "tripId", targetNamespace = "http://trip_planner.example.org/") UUID tripId,
            @WebParam(name = "dateFrom", targetNamespace = "http://trip_planner.example.org/") Date dateFrom,
            @WebParam(name = "dateTo", targetNamespace = "http://trip_planner.example.org/")  Date dateTo
    );

    @jakarta.jws.WebMethod
    Trip setLocation(
            @WebParam(name = "tripId", targetNamespace = "http://trip_planner.example.org/") UUID tripId,
            @WebParam(name = "city", targetNamespace = "http://trip_planner.example.org/") String city,
            @WebParam(name = "country", targetNamespace = "http://trip_planner.example.org/") String country
    );

    @jakarta.jws.WebMethod
    Trip setAccommodation(
            @WebParam(name = "tripId", targetNamespace = "http://trip_planner.example.org/") UUID tripId,
            @WebParam(name = "accommodation", targetNamespace = "http://trip_planner.example.org/") Accommodation accommodation
    );

    @jakarta.jws.WebMethod
    void addCalendarItem(
            @WebParam(name = "item", targetNamespace = "http://trip_planner.example.org/") CalendarItem item
    );
}



