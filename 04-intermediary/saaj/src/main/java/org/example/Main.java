package org.example;

import jakarta.xml.soap.*;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String NAMESPACE_URI = "http://trip_planner.example.org/";
    private static final String PREFIX = "trip";
    private static final String LINE_DIVIDER = "------------------------------------------";

    public static void main(String[] args) {
        try {
            System.out.println("\n" + LINE_DIVIDER + "\nMy trips");
            SOAPMessage viewMyTripsResponse = sendSoapRequest("viewMyTrips", new ArrayList<>());
            processSoapResponse(viewMyTripsResponse, "viewMyTrips");

            System.out.println("\n" + LINE_DIVIDER + "\nMy planned items");
            SOAPMessage viewMyPlannedItemsResponse = sendSoapRequest("viewMyPlannedItems", new ArrayList<>());
            processSoapResponse(viewMyPlannedItemsResponse, "viewMyPlannedItems");

            System.out.println("\n" + LINE_DIVIDER + "\nMy trip 'Sightseeing in Rome'");
            List<SoapParameter> parameters = new ArrayList<>() {{
                add(new SoapParameter("tripName", "Sightseeing in Rome"));
            }};

            SOAPMessage getOrCreateTripResponse = sendSoapRequest("getOrCreate", parameters);
            processSoapResponse(getOrCreateTripResponse, "getOrCreate");
        } catch (SOAPException e) {
            throw new RuntimeException(e);
        }
    }

    private static SOAPMessage sendSoapRequest(String methodName, List<SoapParameter> parameters) throws SOAPException {
        SOAPConnectionFactory soapcf;

        soapcf = SOAPConnectionFactory.newInstance();
        SOAPConnection soapc = soapcf.createConnection();

        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage soapm = mf.createMessage();

        SOAPPart soapp = soapm.getSOAPPart();
        SOAPEnvelope soape = soapp.getEnvelope();
        SOAPBody soapb = soape.getBody();

        soape.getHeader().detachNode();
        SOAPElement soapel = soapb.addBodyElement(
                new QName(NAMESPACE_URI, methodName, PREFIX)
        );

        for (SoapParameter parameter: parameters) {
            soapel.addChildElement(
                    new QName(NAMESPACE_URI, parameter.name(), PREFIX)
            ).addTextNode(parameter.value());
        }

        String endpoint = "http://127.0.0.1:8000/ITripPlanner";
        SOAPMessage response = soapc.call(soapm, endpoint);

        soapc.close();

        return response;
    }

    private static void processSoapResponse(SOAPMessage response, String methodName) throws SOAPException {
        SOAPBody responseBody = response.getSOAPBody();
        if (responseBody.hasFault()) {
            System.out.println(responseBody.getFault().getFaultString());
        } else {
            QName viewMyTripsResponseName = new QName("http://trip_planner.example.org/", methodName + "Response");

            SOAPBodyElement methodResponse = (SOAPBodyElement)
                    responseBody.getChildElements(viewMyTripsResponseName).next();

            var returnNode = methodResponse.getFirstChild();

            System.out.println(LINE_DIVIDER);
            printNodes(returnNode.getChildNodes());

            var nextSibling = returnNode.getNextSibling();

            while (nextSibling != null) {
                System.out.println(LINE_DIVIDER);
                printNodes(nextSibling.getChildNodes());
                nextSibling = nextSibling.getNextSibling();
            }
        }
    }

    private static void printNodes(NodeList nodes) {
        printNodes(nodes, 0);
    }

    private static void printNodes(NodeList nodes, int indentation) {
        for (int i = 0; i < nodes.getLength(); i++) {
            var node = nodes.item(i);

            String indentPrefix = "\t".repeat(indentation);

            if (node.hasChildNodes()) {
                int indent = indentation;
                if(node.getChildNodes().getLength() > 1) {
                    System.out.println(indentPrefix + node.getLocalName() + ":" );
                    indent++;
                }

                printNodes(node.getChildNodes(), indent);
            } else {
                System.out.println(
                        indentPrefix + node.getParentNode().getLocalName() + ": " + node.getTextContent()
                );
            }
        }
    }
}