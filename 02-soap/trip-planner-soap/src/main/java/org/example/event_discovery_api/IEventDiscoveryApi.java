package org.example.event_discovery_api;

import jakarta.jws.WebParam;
import org.example.planned_items.Calendar;
import org.example.planned_items.CalendarItem;
import org.example.planned_items.PlanItem;
import org.example.trip_planner.Accommodation;
import org.example.trip_planner.Trip;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@jakarta.jws.WebService
public interface IEventDiscoveryApi {
    @jakarta.jws.WebMethod
    List<Event> fetchNearEvents(
            @WebParam(name = "lat") double latitude,
            @WebParam(name = "long") double longitude,
            @WebParam(name = "radius") int radius
    );

    @jakarta.jws.WebMethod
    List<Event> fetchNearEventsByGeohash(
            @WebParam(name = "geohash") String geohash,
            @WebParam(name = "radius") int radius
    );


}



