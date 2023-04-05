package org.example.event_discovery_api;

import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebService(endpointInterface = "org.example.event_discovery_api.IEventDiscoveryApi")

public class EventDiscoveryApi implements IEventDiscoveryApi {

    private static final List<Event> mockRomeEvents = new ArrayList<>();

    static {
        double romeLatitude = 41.902782;
        double romeLongitude = 12.496366;

        Event firstConcert = new Event(
                "Smash Into Pieces",
                UUID.fromString("42cf722b-8be7-496e-80a6-3cb4a82f1ff0")
        ).setLocation(romeLatitude, romeLongitude);

        Event secondConcert = new Event(
                "Unlikely Candidates",
                UUID.fromString("79a88bee-e134-4c07-929f-941a44e9d02f")
        ).setLocation(romeLatitude, romeLongitude);

        Event cinema = new Event(
                "Inception",
                UUID.fromString("42a96db0-1316-468c-96ec-44b50396678a")
        ).setLocation(romeLatitude, romeLongitude);

        Event museum = new Event(
                "Film Legends",
                UUID.fromString("3e539557-63dd-4d44-a5c7-9595ca72af7d")
        ).setLocation(romeLatitude, romeLongitude);

        mockRomeEvents.add(firstConcert);
        mockRomeEvents.add(secondConcert);
        mockRomeEvents.add(cinema);
        mockRomeEvents.add(museum);
    }

    public List<Event> fetchNearEvents(double latitude, double longitude, int radius) {
        return mockRomeEvents.stream().filter(event -> {
            // Return event only if it's within the provided radius (calculate from lat + long)
            return true;
        }).toList();
    }

    public List<Event> fetchNearEventsByGeohash(String geohash, int radius) {
        return mockRomeEvents.stream().filter(event -> {
            // Return event only if it's within the provided radius (calculate from geohash)
            return event.name().length() < 13; // random condition at the moment
        }).toList();
    }
}
