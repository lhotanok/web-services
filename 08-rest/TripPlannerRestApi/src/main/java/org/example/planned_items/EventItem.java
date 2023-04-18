package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.ZonedDateTime;
import java.util.UUID;

@XmlRootElement
public class EventItem extends PlanItem {
    public ZonedDateTime dateTimeFrom;
    public ZonedDateTime dateTimeTo;
    public EventItem(){
        super();
    }

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
