package org.example.www.TripPlanner;

public class TripPlannerProxy implements org.example.www.TripPlanner.TripPlanner_PortType {
  private String _endpoint = null;
  private org.example.www.TripPlanner.TripPlanner_PortType tripPlanner_PortType = null;
  
  public TripPlannerProxy() {
    _initTripPlannerProxy();
  }
  
  public TripPlannerProxy(String endpoint) {
    _endpoint = endpoint;
    _initTripPlannerProxy();
  }
  
  private void _initTripPlannerProxy() {
    try {
      tripPlanner_PortType = (new org.example.www.TripPlanner.TripPlanner_ServiceLocator()).getTripPlannerSOAP();
      if (tripPlanner_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tripPlanner_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tripPlanner_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tripPlanner_PortType != null)
      ((javax.xml.rpc.Stub)tripPlanner_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.example.www.TripPlanner.TripPlanner_PortType getTripPlanner_PortType() {
    if (tripPlanner_PortType == null)
      _initTripPlannerProxy();
    return tripPlanner_PortType;
  }
  
  public java.lang.String newOperation(java.lang.String in) throws java.rmi.RemoteException{
    if (tripPlanner_PortType == null)
      _initTripPlannerProxy();
    return tripPlanner_PortType.newOperation(in);
  }
  
  
}