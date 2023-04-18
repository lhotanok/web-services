package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Calendar {
    public final List<CalendarItem> calendarItems;

    public Calendar() {
        this.calendarItems = new ArrayList<>();
    }

    public Calendar(List<CalendarItem> calendarItems) {
        this.calendarItems = calendarItems;
    }

    public Calendar addItem(CalendarItem item) {
        calendarItems.add(item);

        return this;
    }

    public List<CalendarItem> getItems() {
        return calendarItems;
    }
}
