package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.ZonedDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class CalendarItem {
    public final PlanItem planItem;
    public final ZonedDateTime from;
    public final ZonedDateTime to;

    public CalendarItem(PlanItem item, ZonedDateTime from, ZonedDateTime to) {
        this.planItem = item;
        this.from = from;
        this.to = to;
    }
}
