package com.example.intermediary;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.xml.soap.*;

@WebServlet(name = "tripPlannerServlet", value = "/trip-planner-servlet")
public class TripPlannerServlet extends HttpServlet {
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

        String endpoint = "http://127.0.0.1:8000/ITripPlanner";
        SOAPMessage response = soapc.call(soapm, endpoint);

        soapc.close();

        return response;
    }
}