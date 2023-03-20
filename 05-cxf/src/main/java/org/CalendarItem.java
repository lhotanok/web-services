package org;

import java.util.Date;

public class CalendarItem {
	public PlanItem planItem;
    public Date from;
    public Date to;
    
    public CalendarItem() {}

    public CalendarItem(PlanItem item, Date from, Date to) {
        this.planItem = item;
        this.from = from;
        this.to = to;
    }
}
