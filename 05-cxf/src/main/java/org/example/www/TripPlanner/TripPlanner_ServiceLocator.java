/**
 * TripPlanner_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.TripPlanner;

public class TripPlanner_ServiceLocator extends org.apache.axis.client.Service implements org.example.www.TripPlanner.TripPlanner_Service {

    public TripPlanner_ServiceLocator() {
    }


    public TripPlanner_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TripPlanner_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TripPlannerSOAP
    private java.lang.String TripPlannerSOAP_address = "http://www.example.org/";

    public java.lang.String getTripPlannerSOAPAddress() {
        return TripPlannerSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TripPlannerSOAPWSDDServiceName = "TripPlannerSOAP";

    public java.lang.String getTripPlannerSOAPWSDDServiceName() {
        return TripPlannerSOAPWSDDServiceName;
    }

    public void setTripPlannerSOAPWSDDServiceName(java.lang.String name) {
        TripPlannerSOAPWSDDServiceName = name;
    }

    public org.example.www.TripPlanner.TripPlanner_PortType getTripPlannerSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TripPlannerSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTripPlannerSOAP(endpoint);
    }

    public org.example.www.TripPlanner.TripPlanner_PortType getTripPlannerSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.example.www.TripPlanner.TripPlannerSOAPStub _stub = new org.example.www.TripPlanner.TripPlannerSOAPStub(portAddress, this);
            _stub.setPortName(getTripPlannerSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTripPlannerSOAPEndpointAddress(java.lang.String address) {
        TripPlannerSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.example.www.TripPlanner.TripPlanner_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.example.www.TripPlanner.TripPlannerSOAPStub _stub = new org.example.www.TripPlanner.TripPlannerSOAPStub(new java.net.URL(TripPlannerSOAP_address), this);
                _stub.setPortName(getTripPlannerSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TripPlannerSOAP".equals(inputPortName)) {
            return getTripPlannerSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.example.org/TripPlanner/", "TripPlanner");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.example.org/TripPlanner/", "TripPlannerSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TripPlannerSOAP".equals(portName)) {
            setTripPlannerSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
