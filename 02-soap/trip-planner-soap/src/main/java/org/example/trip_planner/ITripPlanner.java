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
    PlaceItem savePlaceItem(
            @WebParam(name = "id") UUID uuid,
            @WebParam(name = "lat") double latitude,
            @WebParam(name = "long") double longitude
    );

    @jakarta.jws.WebMethod
    EventItem saveEventItem(
            @WebParam(name = "id") UUID uuid,
            @WebParam(name = "lat") double latitude,
            @WebParam(name = "long") double longitude
    );

    @jakarta.jws.WebMethod
    Trip getOrCreate(@WebParam(name = "tripName") String tripName);

    @jakarta.jws.WebMethod
    Trip setDate(
            @WebParam(name = "tripId") UUID tripId,
            @WebParam(name = "dateFrom") Date dateFrom,
            @WebParam(name = "dateTo")  Date dateTo
    );

    @jakarta.jws.WebMethod
    Trip setLocation(
            @WebParam(name = "tripId") UUID tripId,
            @WebParam(name = "city") String city,
            @WebParam(name = "country") String country
    );

    @jakarta.jws.WebMethod
    Trip setAccommodation(
            @WebParam(name = "tripId") UUID tripId,
            @WebParam(name = "accommodation") Accommodation accommodation
    );

    @jakarta.jws.WebMethod
    Calendar addCalendarItem(@WebParam(name = "item") CalendarItem item);
}



