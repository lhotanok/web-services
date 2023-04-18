package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.trip_planner.Trip;
import org.example.trip_planner.TripPlanner;

import java.util.List;

@Path("/trips")
public class TripPlannerRestApi {
    private TripPlanner tripPlanner = new TripPlanner();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Trip> getAllTrips() {
        return tripPlanner.viewMyTrips();
    }
}
