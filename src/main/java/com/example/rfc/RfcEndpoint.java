package com.example.rfc;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.validation.annotation.Validated;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.rfc.service.RfcService;
import jakarta.validation.Valid;


@Validated
@Endpoint
public class RfcEndpoint {
	RfcService rfcServices = new RfcService();
    private static final String NAMESPACE_URI = "http://example.com/rfc";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRFCRequest")
    @ResponsePayload
    public GetRFCResponse getCountry(@RequestPayload @Valid GetRFCRequest generarRFCRequest) {
    	GetRFCResponse response = new GetRFCResponse();

     
        Rfc rfcData = generarRFCRequest.getRfc();
        String nombre = rfcData.getNombre();
        String primerApellido = rfcData.getPrimerApellido();
        String segundoApellido = rfcData.getSegundoApellido();
        String fechaNacimiento = rfcData.getFechaNacimiento();

        String rfc = rfcServices.generateRFCFromData(nombre, primerApellido, segundoApellido, fechaNacimiento);

        response.setRfc(rfc);

        return response;
    }
}