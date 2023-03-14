package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlaceItem extends PlanItem {
    public PlaceItem(UUID uuid, double latitude, double longitude) {
        super(uuid, latitude, longitude);
    }
}
