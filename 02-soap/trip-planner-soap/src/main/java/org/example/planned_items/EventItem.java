package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.ZonedDateTime;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class EventItem extends PlanItem {
    private ZonedDateTime dateTimeFrom;
    private ZonedDateTime dateTimeTo;

    public EventItem(UUID uuid, double latitude, double longitude) {
        super(uuid, latitude, longitude);
    }

    public ZonedDateTime from() {
        return dateTimeFrom;
    }

    public ZonedDateTime to() {
        return dateTimeTo;
    }

    public EventItem setDate(ZonedDateTime dateTimeFrom, ZonedDateTime dateTimeTo) {
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;

        return this;
    }
}
