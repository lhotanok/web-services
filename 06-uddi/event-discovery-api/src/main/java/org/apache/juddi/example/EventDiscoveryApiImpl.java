/*
 * Copyright 2001-2010 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.apache.juddi.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import org.apache.juddi.v3.annotations.UDDIService;
import org.apache.juddi.v3.annotations.UDDIServiceBinding;

/**
 * This example show you how to use UDDI Annotations to decorate a class.
 * When the Servlet Listener
 *
 */

@UDDIService(
		businessKey="uddi:${keyDomain}:${department}-asf",
		serviceKey="uddi:${keyDomain}:services-events${department}",
		description = "Event Discovery API service")
@UDDIServiceBinding(
		bindingKey="uddi:${keyDomain}:${serverName}-${serverPort}-events${department}-wsdl",
	    description="WSDL endpoint for the events${department} Service. This service is used for "
				  + "testing the jUDDI annotation functionality",
	    accessPointType="wsdlDeployment",
	    accessPoint="http://${serverName}:${serverPort}/event-discovery-api/services/events?wsdl")
@WebService(
		endpointInterface = "org.apache.juddi.example.EventDiscoveryApi",
        serviceName = "EventDiscoveryApi")

public class EventDiscoveryApiImpl implements EventDiscoveryApi {

    private static final List<Event> mockRomeEvents;

    static {
    	mockRomeEvents = new ArrayList<>();
    	
        Event firstConcert = new Event(
                "Smash Into Pieces",
                UUID.fromString("42cf722b-8be7-496e-80a6-3cb4a82f1ff0")
        ).setLocation(50.075538, 14.437800);

        Event secondConcert = new Event(
                "Unlikely Candidates",
                UUID.fromString("79a88bee-e134-4c07-929f-941a44e9d02f")
        ).setLocation("u2fkbecr1hggq");

        Event cinema = new Event(
                "Inception",
                UUID.fromString("42a96db0-1316-468c-96ec-44b50396678a")
        );

        Event museum = new Event(
                "Film Legends",
                UUID.fromString("3e539557-63dd-4d44-a5c7-9595ca72af7d")
        ).setAddress(
        		new Address("Šatlavská 141", "Český Krumlov", "Česká republika")
        );

        mockRomeEvents.add(firstConcert);
        mockRomeEvents.add(secondConcert);
        mockRomeEvents.add(cinema);
        mockRomeEvents.add(museum);
    }

    public List<Event> fetchNearEvents(double latitude, double longitude, int radius) {
    	List<Event> nearEvents = new ArrayList<>();
    	
    	for (Event event : mockRomeEvents) {
    		// TODO: Add only if it's within the provided radius (calculate from lat + long)
    		nearEvents.add(event);
    	}
    	
        return nearEvents;
    }

    public List<Event> fetchNearEventsByGeohash(String geohash, int radius) {
    	List<Event> nearEvents = new ArrayList<>();
    	
    	for (Event event : mockRomeEvents) {
    		// TODO: Add only if it's within the provided radius (calculate from geohash)
    		nearEvents.add(event);
    	}
    	
        return nearEvents;
    }

}
