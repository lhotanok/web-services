package org.example.trip_planner;

import org.example.planned_items.Calendar;
import org.example.planned_items.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TripPlanner {
    private static final Map<UUID, Trip> mockTrips = new HashMap<>();
    private static final Map<UUID, PlanItem> mockPlannedItems = new HashMap<>();
    private static final Calendar mockCalendar = new Calendar();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

    static {
        Date dateFrom, dateTo, secondDateFrom, secondDateTo;

        try {
            dateFrom = dateFormat.parse ( "2023-05-01" );
            dateTo = dateFormat.parse("2023-05-05");

            secondDateFrom = dateFormat.parse ( "2023-08-12" );
            secondDateTo = dateFormat.parse("2023-08-20");

        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }

        Accommodation mockAccommodation = new Accommodation(true)
                .setName("Hotel Golden")
                .setAddress(new Address("Via Marche, 84", "Rome", "Italy"))
                ;

        Trip mockTrip = new Trip("Sightseeing in Rome")
                .setDate(dateFrom, dateTo)
                .setLocation("Rome", "Italy")
                .setAccommodation(mockAccommodation)
                ;

        Accommodation secondMockAccommodation = new Accommodation(true)
                .setName("Hotel MH Peniche")
                .setAddress(new Address("Av. Monsenhor Bastos, 2520-206", "Peniche", "Portugal"))
                ;

        Trip secondMockTrip = new Trip("Surfing in Portugal")
                .setDate(secondDateFrom, secondDateTo)
                .setLocation("Peniche", "Portugal")
                .setAccommodation(secondMockAccommodation)
                ;

        mockTrips.put(mockTrip.id(), mockTrip);
        mockTrips.put(secondMockTrip.id(), secondMockTrip);
    }

    static {
        ZonedDateTime dateTimeConcertFrom, dateTimeConcertTo, dateTimeCinemaFrom, dateTimeCinemaTo;

        try {
            dateTimeConcertFrom = ZonedDateTime.parse("2023-05-01 20:00:00 Europe/Rome", formatter);
            dateTimeConcertTo = ZonedDateTime.parse("2023-05-01 21:30:00 Europe/Rome", formatter);

            dateTimeCinemaFrom = ZonedDateTime.parse("2023-05-02 19:30:00 Europe/Rome", formatter);
            dateTimeCinemaTo = ZonedDateTime.parse("2023-05-02 23:00:00 Europe/Rome", formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e);
        }

        EventItem eventConcert = new EventItem(
                UUID.fromString("42cf722b-8be7-496e-80a6-3cb4a82f1ff0"),
                41.9027835,
                12.4963655
        )
                .setDate(dateTimeConcertFrom, dateTimeConcertTo);

        EventItem eventCinema = new EventItem(
                UUID.fromString("42a96db0-1316-468c-96ec-44b50396678a"),
                41.9617835,
                12.1263655
        )
                .setDate(dateTimeCinemaFrom, dateTimeCinemaTo);

        PlanItem placeRestaurant = new PlaceItem(UUID.randomUUID(), 41.9004881, 12.4686586);

        mockPlannedItems.put(eventConcert.id, eventConcert);
        mockPlannedItems.put(eventCinema.id, eventCinema);
        mockPlannedItems.put(placeRestaurant.id, placeRestaurant);
    }

    public List<Trip> viewMyTrips() {
        return mockTrips.values().stream().toList();
    }

    public List<PlanItem> viewMyPlannedItems() {
        return mockPlannedItems.values().stream().toList();
    }

    public Calendar planMyTrip() {
        List<CalendarItem> plannedItems = new ArrayList<>();

        mockPlannedItems.values().forEach(item -> {
            if (item instanceof EventItem event) {
                plannedItems.add(
                        new CalendarItem(event, event.from(), event.to())
                );
            } else {
                // pick some free slot
                ZonedDateTime randomFromDateTime = ZonedDateTime.parse("2023-05-03 12:30:00 Europe/Rome", formatter);
                ZonedDateTime randomToDateTime = ZonedDateTime.parse("2023-05-03 13:30:00 Europe/Rome", formatter);

                plannedItems.add(
                        new CalendarItem(item, randomFromDateTime, randomToDateTime)
                );
            }
        });

        return new Calendar(plannedItems);
    }

    public void savePlaceItem(UUID uuid, double latitude, double longitude) {
        PlaceItem place = new PlaceItem(uuid, latitude, longitude);
        mockPlannedItems.put(uuid, place);
    }

    public void saveEventItem(UUID uuid, double latitude, double longitude) {
        EventItem event = new EventItem(uuid, latitude, longitude);
        mockPlannedItems.put(uuid, event);
    }

    public void addCalendarItem(CalendarItem item) {
        mockCalendar.addItem(item);
    }

    public Trip getTrip(UUID tripId) {
        return mockTrips.get(tripId);
    }

    public Trip getOrCreate(Trip trip) {
        for (Trip mockTrip : mockTrips.values()) {
            if (mockTrip.name().equalsIgnoreCase(trip.name())
                    && mockTrip.locationCity.equalsIgnoreCase(trip.locationCity)
                    && mockTrip.locationCountry.equalsIgnoreCase((trip.locationCity))
                    && mockTrip.dateFrom.toString().equalsIgnoreCase(trip.dateFrom.toString())
                    && mockTrip.dateTo.toString().equalsIgnoreCase(trip.dateTo.toString())) {
                return trip;
            }
        }

        mockTrips.put(trip.id(), trip);

        return trip;
    }

    public void replaceTrip(Trip newTrip) {
        mockTrips.replace(newTrip.id(), newTrip);
    }

    public boolean deleteTrip(UUID tripId) {
        if (mockTrips.containsKey(tripId)) {
            mockTrips.remove(tripId);
            return true;
        }

        return false;
    }

    public boolean tripExists(UUID tripId) {
        return mockTrips.containsKey(tripId);
    }
}
