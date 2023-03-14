package org.example;

import jakarta.xml.soap.*;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;

public class Main {
    public static void main(String[] args) {
        SOAPConnectionFactory soapcf;

        try {
            soapcf = SOAPConnectionFactory.newInstance();
            SOAPConnection soapc = soapcf.createConnection();

            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage soapm = mf.createMessage();

            SOAPPart soapp = soapm.getSOAPPart();
            SOAPEnvelope soape = soapp.getEnvelope();
            SOAPBody soapb = soape.getBody();

            QName name = new QName("http://trip_planner.example.org/", "viewMyTrips", "temp");
            soapb.addBodyElement(name);

            soape.getHeader().detachNode();
            String endpoint = "http://127.0.0.1:8000/ITripPlanner";
            SOAPMessage response = soapc.call(soapm, endpoint);

            soapc.close();

            SOAPBody responseBody = response.getSOAPBody();
            if (responseBody.hasFault()) {
                System.out.println(responseBody.getFault().getFaultString());
            } else {
                QName viewMyTripsResponseName = new QName("http://trip_planner.example.org/", "viewMyTripsResponse");

                SOAPBodyElement viewMyTripsResponse = (SOAPBodyElement)
                        responseBody.getChildElements(viewMyTripsResponseName).next();

                var returnNode = viewMyTripsResponse.getFirstChild();

                System.out.println("------------------------------------------");
                printNodes(returnNode.getChildNodes());

                var nextSibling = returnNode.getNextSibling();

                while (nextSibling != null) {
                    System.out.println("------------------------------------------");
                    printNodes(nextSibling.getChildNodes());
                    nextSibling = nextSibling.getNextSibling();
                }

            }

        } catch (SOAPException e) {
            throw new RuntimeException(e);
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