package org;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "ITripPlanner", targetNamespace = "http://org/")
public interface ITripPlanner {
    @WebMethod(operationName = "viewMyTrips", action = "urn:ViewMyTrips")
	Trip[] viewMyTrips();

    @WebMethod(operationName = "viewMyPlannedItems", action = "urn:ViewMyPlannedItems")
	PlanItem[] viewMyPlannedItems();

    @WebMethod(operationName = "planMyTrip", action = "urn:PlanMyTrip")
	Calendar planMyTrip();

    @WebMethod(operationName = "savePlaceItem", action = "urn:SavePlaceItem")
	void savePlaceItem(@WebParam(name = "uuid") String uuid, @WebParam(name = "latitude") double latitude, @WebParam(name = "longitude") double longitude);

    @WebMethod(operationName = "saveEventItem", action = "urn:SaveEventItem")
	void saveEventItem(@WebParam(name = "uuid") String uuid, @WebParam(name = "latitude") double latitude, @WebParam(name = "longitude") double longitude);

    @WebMethod(operationName = "getOrCreate", action = "urn:GetOrCreate")
	Trip getOrCreate(@WebParam(name = "tripName") String tripName);

    @WebMethod(operationName = "setDate", action = "urn:SetDate")
	Trip setDate(@WebParam(name = "tripId") String tripId, @WebParam(name = "dateFrom") Date dateFrom, @WebParam(name = "dateTo") Date dateTo);

    @WebMethod(operationName = "setLocation", action = "urn:SetLocation")
	Trip setLocation(@WebParam(name = "tripId") String tripId, @WebParam(name = "city") String city, @WebParam(name = "country") String country);

    @WebMethod(operationName = "setAccommodation", action = "urn:SetAccommodation")
	Trip setAccommodation(@WebParam(name = "tripId") String tripId, @WebParam(name = "accommodation") Accommodation accommodation);

    @WebMethod(operationName = "addCalendarItem", action = "urn:AddCalendarItem")
	void addCalendarItem(@WebParam(name = "item") CalendarItem item);

}
