
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**
 * This class was generated by Apache CXF 3.5.5
 * 2023-03-21T01:48:05.406+01:00
 * Generated source version: 3.5.5
 *
 */
public class ITripPlannerClient {

    public static void main(String[] args) throws Exception {
        QName serviceName = new QName("http://org/", "TripPlannerService");
        QName portName = new QName("http://org/", "TripPlannerPort");

        Service service = Service.create(serviceName);
        service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,
                        "http://localhost:9090/TripPlannerPort");
        org.ITripPlanner client = service.getPort(portName,  org.ITripPlanner.class);

        // Insert code to invoke methods on the client here
    }

}