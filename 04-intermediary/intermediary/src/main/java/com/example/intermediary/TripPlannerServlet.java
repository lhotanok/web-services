package com.example.intermediary;

import java.io.*;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.xml.soap.*;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;

@WebServlet(name = "tripPlannerServlet", value = "/trip-planner-servlet")
public class TripPlannerServlet extends HttpServlet {
    private static final String NAMESPACE_URI = "http://trip_planner.example.org/";
    private static final String PREFIX = "trip";


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SOAPMessage soapResponse = sendSoapRequest(req.getInputStream());
            soapResponse.writeTo(resp.getOutputStream());
        } catch (SOAPException e) {
            throw new RuntimeException(e);
        }
    }
    private static SOAPMessage sendSoapRequest(ServletInputStream inputStream) throws SOAPException, IOException {
        SOAPConnectionFactory soapcf;

        soapcf = SOAPConnectionFactory.newInstance();
        SOAPConnection soapc = soapcf.createConnection();

        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage soapm = mf.createMessage(null, inputStream);

        SOAPHeader soapHeader = soapm.getSOAPHeader();
        Node lowercaseAttribute = soapHeader.getFirstChild()
                .getAttributes()
                .getNamedItem("lowercase");

        String endpoint = "http://127.0.0.1:8000/ITripPlanner";
        SOAPMessage response = soapc.call(soapm, endpoint);

        if (Objects.equals(lowercaseAttribute.getNodeValue(), "true")) {
            addLowercaseInfoHeader(response);
        }

        soapc.close();

        return response;
    }

    private static void addLowercaseInfoHeader(SOAPMessage response) throws SOAPException {
        response.getSOAPPart().getEnvelope().addHeader();

        response.getSOAPHeader().addHeaderElement(
                new QName(NAMESPACE_URI, "tweaked", PREFIX)
        ).addAttribute(
                new QName(null, "xmlns", ""),
                "http://tweaks.com/"
        ).addTextNode("Lowercase transformation applied");
    }
}