package org;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlaceItem extends PlanItem {
	public PlaceItem() {
		super();
	}
    public PlaceItem(String uuid, double latitude, double longitude) {
        super(uuid, latitude, longitude);
    }
}
