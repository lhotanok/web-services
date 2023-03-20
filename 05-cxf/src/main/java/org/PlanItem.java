package org;

import java.util.UUID;

public abstract class PlanItem {
	public final UUID id;
    public final double latitude;
    public final double longitude;
    public PlanItem(UUID uuid, double latitude, double longitude) {
        this.id = uuid;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
