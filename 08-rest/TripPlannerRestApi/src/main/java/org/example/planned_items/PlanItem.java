package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.UUID;

@XmlRootElement
public abstract class PlanItem {
    public UUID id;
    public double latitude;
    public double longitude;
    public PlanItem(){}
    public PlanItem(UUID uuid, double latitude, double longitude) {
        this.id = uuid;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
