
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

@XmlRootElement(name = "getOrCreate", namespace = "http://org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrCreate", namespace = "http://org/")

public class GetOrCreate {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}

