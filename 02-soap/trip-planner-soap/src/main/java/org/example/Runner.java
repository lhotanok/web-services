package org.example;

import jakarta.xml.ws.Endpoint;
import org.example.event_discovery_api.EventDiscoveryApi;
import org.example.trip_planner.TripPlanner;

public class Runner {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8000/ITripPlanner", new TripPlanner());
        Endpoint.publish("http://127.0.0.1:8000/IEventDiscoveryApi", new EventDiscoveryApi());
    }
}