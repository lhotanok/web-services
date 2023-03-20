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
	void savePlaceItem(@WebParam(name = "arg0") String uuid, @WebParam(name = "arg1") double latitude, @WebParam(name = "arg2") double longitude);

    @WebMethod(operationName = "saveEventItem", action = "urn:SaveEventItem")
	void saveEventItem(@WebParam(name = "arg0") String uuid, @WebParam(name = "arg1") double latitude, @WebParam(name = "arg2") double longitude);

    @WebMethod(operationName = "getOrCreate", action = "urn:GetOrCreate")
	Trip getOrCreate(@WebParam(name = "arg0") String tripName);

    @WebMethod(operationName = "setDate", action = "urn:SetDate")
	Trip setDate(@WebParam(name = "arg0") String tripId, @WebParam(name = "arg1") Date dateFrom, @WebParam(name = "arg2") Date dateTo);

    @WebMethod(operationName = "setLocation", action = "urn:SetLocation")
	Trip setLocation(@WebParam(name = "arg0") String tripId, @WebParam(name = "arg1") String city, @WebParam(name = "arg2") String country);

    @WebMethod(operationName = "setAccommodation", action = "urn:SetAccommodation")
	Trip setAccommodation(@WebParam(name = "arg0") String tripId, @WebParam(name = "arg1") Accommodation accommodation);

    @WebMethod(operationName = "addCalendarItem", action = "urn:AddCalendarItem")
	void addCalendarItem(@WebParam(name = "arg0") CalendarItem item);

}
