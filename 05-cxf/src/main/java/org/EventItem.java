package org;

import java.util.Date;

public class EventItem extends PlanItem {
    private Date dateTimeFrom;
    private Date dateTimeTo;
    
    public EventItem() {
    	super();
    }

    public EventItem(String uuid, double latitude, double longitude) {
        super(uuid, latitude, longitude);
    }

    public Date from() {
        return dateTimeFrom;
    }

    public Date to() {
        return dateTimeTo;
    }

    public EventItem setDate(Date dateTimeFrom, Date dateTimeTo) {
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;

        return this;
    }
}