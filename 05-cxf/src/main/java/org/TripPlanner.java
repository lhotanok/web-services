package org;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.*;

@SuppressWarnings("deprecation")
public class TripPlanner implements ITripPlanner {
    private static final Map<String, Trip> mockTrips = new HashMap<>();
    private static final Map<String, PlanItem> mockPlannedItems = new HashMap<>();
    private static final Calendar mockCalendar = new Calendar();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
    	Date dateTimeConcertFrom, dateTimeConcertTo, dateTimeCinemaFrom, dateTimeCinemaTo;

        try {
            dateTimeConcertFrom = new Date("2023-05-01 20:00:00 Europe/Rome");
            dateTimeConcertTo = new Date("2023-05-01 21:30:00 Europe/Rome");

            dateTimeCinemaFrom = new Date("2023-05-02 19:30:00 Europe/Rome");
            dateTimeCinemaTo = new Date("2023-05-02 23:00:00 Europe/Rome");
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e);
        }

        EventItem eventConcert = new EventItem(
                "42cf722b-8be7-496e-80a6-3cb4a82f1ff0",
                41.9027835,
                12.4963655
        )
                .setDate(dateTimeConcertFrom, dateTimeConcertTo);

        EventItem eventCinema = new EventItem(
                "42a96db0-1316-468c-96ec-44b50396678a",
                41.9617835,
                12.1263655
        )
                .setDate(dateTimeCinemaFrom, dateTimeCinemaTo);

        PlanItem placeRestaurant = new PlaceItem(UUID.randomUUID().toString(), 41.9004881, 12.4686586);

        mockPlannedItems.put(eventConcert.id, eventConcert);
        mockPlannedItems.put(eventCinema.id, eventCinema);
        mockPlannedItems.put(placeRestaurant.id, placeRestaurant);
    }

    public Trip[] viewMyTrips() {
        return (Trip[]) mockTrips.values().toArray();
    }

    public PlanItem[] viewMyPlannedItems() {
        return (PlanItem[]) mockPlannedItems.values().toArray();
    }

    public Calendar planMyTrip() {
        List<CalendarItem> plannedItems = new ArrayList<>();

        mockPlannedItems.values().forEach(item -> {
            if (item instanceof EventItem) {
            	EventItem event = (EventItem)item;
                plannedItems.add(
                        new CalendarItem(event, event.from(), event.to())
                );
            } else {
                // pick some free slot
                Date randomFromDateTime = new Date("2023-05-03 12:30:00 Europe/Rome");
                Date randomToDateTime = new Date("2023-05-03 13:30:00 Europe/Rome");

                plannedItems.add(
                        new CalendarItem(item, randomFromDateTime, randomToDateTime)
                );
            }
        });

        return new Calendar(plannedItems);
    }

    public void savePlaceItem(String uuid, double latitude, double longitude) {
        PlaceItem place = new PlaceItem(uuid, latitude, longitude);
        mockPlannedItems.put(uuid, place);
    }

    public void saveEventItem(String uuid, double latitude, double longitude) {
        EventItem event = new EventItem(uuid, latitude, longitude);
        mockPlannedItems.put(uuid, event);
    }

    public void addCalendarItem(CalendarItem item) {
        mockCalendar.addItem(item);
    }

    public Trip getOrCreate(String tripName) {
        for (Trip trip : mockTrips.values()) {
            if (trip.name().equalsIgnoreCase(tripName)) {
                return trip;
            }
        }

        Trip newTrip = new Trip(tripName);
        mockTrips.put(newTrip.id(), newTrip);

        return newTrip;
    }

    public Trip setDate(String tripId, Date dateFrom, Date dateTo) {
        Trip trip = tryGetTrip(tripId);
        trip.setDate(dateFrom, dateTo);

        return trip;
    }

    public Trip setLocation(String tripId, String city, String country) {
        Trip trip = tryGetTrip(tripId);
        trip.setLocation(city, country);

        return trip;
    }

    public Trip setAccommodation(String tripId, Accommodation accommodation) {
        Trip trip = tryGetTrip(tripId);
        trip.setAccommodation(accommodation);

        return trip;
    }

    private Trip tryGetTrip(String tripId) {
        if (!mockTrips.containsKey(tripId)) {
            throw new IllegalArgumentException("No trip found for uuid: " + tripId);
        }

        return mockTrips.get(tripId);
    }
}
