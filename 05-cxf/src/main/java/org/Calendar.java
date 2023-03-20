package org;

import java.util.List;

public class Calendar {
	private CalendarItem[] calendarItems;

    public Calendar() {
        this.calendarItems = new CalendarItem[0];
    }

    public Calendar(List<CalendarItem> calendarItems) {
        this.calendarItems = calendarItems.toArray(new CalendarItem[0]);
    }

    public Calendar addItem(CalendarItem item) {        
        int i;
        
        CalendarItem updatedItems[] = new CalendarItem[calendarItems.length + 1];
    
        for (i = 0; i < calendarItems.length; i++)
        	updatedItems[i] = calendarItems[i];
    
        updatedItems[calendarItems.length] = item;
    

        return this;
    }

    public CalendarItem[] getItems() {
        return calendarItems;
    }
}
