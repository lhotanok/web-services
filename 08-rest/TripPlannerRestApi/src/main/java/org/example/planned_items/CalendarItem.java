package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.ZonedDateTime;

@XmlRootElement
public class CalendarItem {
    public PlanItem planItem;
    public ZonedDateTime from;
    public ZonedDateTime to;

    public CalendarItem() {}

    public CalendarItem(PlanItem item, ZonedDateTime from, ZonedDateTime to) {
        this.planItem = item;
        this.from = from;
        this.to = to;
    }
}
