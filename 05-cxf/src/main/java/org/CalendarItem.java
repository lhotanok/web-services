package org;

import java.time.ZonedDateTime;

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
