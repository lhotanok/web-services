package org;

import java.util.Date;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "ITripPlanner", targetNamespace = "http://trip_planner.example.org/")
public interface ITripPlanner {
	@WebMethod(operationName = "viewMyTrips", action = "urn:viewMyTrips")
    Trip[] viewMyTrips();

    @WebMethod(operationName = "viewMyPlannedItems", action = "urn:viewMyPlannedItems")
    PlanItem[] viewMyPlannedItems();

    @WebMethod(operationName = "planMyTrip", action = "urn:planMyTrip")
    Calendar planMyTrip();

    @WebMethod(operationName = "savePlaceItem", action = "urn:savePlaceItem")
    void savePlaceItem(
            @WebParam(name = "id") UUID uuid,
            @WebParam(name = "lat") double latitude,
            @WebParam(name = "long") double longitude
    );

    @WebMethod(operationName = "saveEventItem", action = "urn:saveEventItem")
    void saveEventItem(
            @WebParam(name = "id") UUID uuid,
            @WebParam(name = "lat") double latitude,
            @WebParam(name = "long") double longitude
    );

    @WebMethod(operationName = "getOrCreate", action = "urn:getOrCreate")
    Trip getOrCreate(
            @WebParam(name = "tripName") String tripName
    );

    @WebMethod(operationName = "setDate", action = "urn:setDate")
    Trip setDate(
            @WebParam(name = "tripId") UUID tripId,
            @WebParam(name = "dateFrom") Date dateFrom,
            @WebParam(name = "dateTo")  Date dateTo
    );

    @WebMethod(operationName = "setLocation", action = "urn:setLocation")
    Trip setLocation(
            @WebParam(name = "tripId") UUID tripId,
            @WebParam(name = "city") String city,
            @WebParam(name = "country") String country
    );

    @WebMethod(operationName = "setAccommodation", action = "urn:setAccommodation")
    Trip setAccommodation(
            @WebParam(name = "tripId") UUID tripId,
            @WebParam(name = "accommodation") Accommodation accommodation
    );

    @WebMethod(operationName = "addCalendarItem", action = "urn:addCalendarItem")
    void addCalendarItem(
            @WebParam(name = "item") CalendarItem item
    );

}
