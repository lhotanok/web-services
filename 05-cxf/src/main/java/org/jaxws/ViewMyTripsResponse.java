
package org.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.5.5
 * Tue Mar 21 00:31:44 CET 2023
 * Generated source version: 3.5.5
 */

@XmlRootElement(name = "viewMyTripsResponse", namespace = "http://org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "viewMyTripsResponse", namespace = "http://org/")

public class ViewMyTripsResponse {

    @XmlElement(name = "return")
    private org.Trip[] _return;

    public org.Trip[] getReturn() {
        return this._return;
    }

    public void setReturn(org.Trip[] new_return)  {
        this._return = new_return;
    }

}

