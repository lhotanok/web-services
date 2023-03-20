/**
 * TripPlanner_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.TripPlanner;

public interface TripPlanner_Service extends javax.xml.rpc.Service {
    public java.lang.String getTripPlannerSOAPAddress();

    public org.example.www.TripPlanner.TripPlanner_PortType getTripPlannerSOAP() throws javax.xml.rpc.ServiceException;

    public org.example.www.TripPlanner.TripPlanner_PortType getTripPlannerSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
