package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.xml.bind.JAXBElement;
import org.example.trip_planner.Trip;
import org.example.trip_planner.TripPlanner;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Path("/trips")
public class TripPlannerRestApi {

    @Context
    UriInfo uriInfo;
    private TripPlanner tripPlanner = new TripPlanner();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Trip> getAllTrips() {
        return tripPlanner.viewMyTrips();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{tripId}")
    public Response getTrip(
            @PathParam("tripId") UUID tripId
    ) {
        return tripPlanner.tripExists(tripId)
                ? Response.ok(tripPlanner.getTrip(tripId)).build()
                : Response.status(404).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createTrip(
            JAXBElement<Trip> tripElement
    ) {
        Trip trip = tripElement.getValue();
        boolean tripExists = tripPlanner.tripExists(trip.id());

        if (tripExists) {
            return Response
                    .status(409)
                    .entity("Trip with the provided id \"" + trip.id() + "\" already exists.")
                    .build();
        }

        Trip newTrip = tripPlanner.getOrCreate(trip);

        return Response.created(
                URI.create(uriInfo.getAbsolutePath() + "/" + newTrip.id())
        ).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{tripId}")
    public Response replaceTrip(
            @PathParam("tripId") UUID tripId, JAXBElement<Trip> tripElement
    ) {
        Trip trip = tripElement.getValue();

        if (tripId.hashCode() != trip.id().hashCode()) {
            return Response
                    .status(409)
                    .entity("Trip ID in the request URL must be same as trip ID from the request body")
                    .build();
        }

        tripPlanner.replaceTrip(trip);

        return Response.noContent().build();
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
            : Response.noContent().build();
    }

}
