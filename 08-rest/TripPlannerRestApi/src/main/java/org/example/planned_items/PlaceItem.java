package org.example.planned_items;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.UUID;

@XmlRootElement
public class PlaceItem extends PlanItem {
    public PlaceItem(){
        super();
    }
    public PlaceItem(UUID uuid, double latitude, double longitude) {
        super(uuid, latitude, longitude);
    }
}
