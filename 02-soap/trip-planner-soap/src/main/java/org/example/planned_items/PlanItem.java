package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
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
