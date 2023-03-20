package org;

import java.util.Date;

public interface ITripPlanner {
    Trip[] viewMyTrips();

    PlanItem[] viewMyPlannedItems();

    Calendar planMyTrip();

    void savePlaceItem(String uuid, double latitude, double longitude);

    void saveEventItem(String uuid, double latitude, double longitude);

    Trip getOrCreate(String tripName);

    Trip setDate(String tripId, Date dateFrom, Date dateTo);

    Trip setLocation(String tripId, String city, String country);

    Trip setAccommodation(String tripId, Accommodation accommodation);

    void addCalendarItem(CalendarItem item);

}
