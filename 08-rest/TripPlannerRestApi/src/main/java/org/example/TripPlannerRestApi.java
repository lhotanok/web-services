package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.trip_planner.Trip;
import org.example.trip_planner.TripPlanner;

import java.util.List;
import java.util.UUID;

@Path("/trips")
public class TripPlannerRestApi {
    private TripPlanner tripPlanner = new TripPlanner();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Trip> getAllTrips() {
        return tripPlanner.viewMyTrips();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{tripId}")
    public Response deleteTrip(
            @PathParam("tripId") UUID tripId
    ) {
        boolean tripDeleted = tripPlanner.deleteTrip(tripId);

        return tripDeleted
            ? Response.status(200).build()
            : Response.status(204).entity("No trip with id \"" + tripId + "\" was found.").build();
    }

}
