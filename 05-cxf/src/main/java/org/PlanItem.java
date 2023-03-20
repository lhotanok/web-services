package org;


public class PlanItem {
	public String id;
    public double latitude;
    public double longitude;
    
    public PlanItem() {}
    
    public PlanItem(String uuid, double latitude, double longitude) {
        this.id = uuid;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
