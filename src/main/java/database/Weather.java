/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Jersey REST client generated for REST resource:Weather Report Service
 * [getForecastRSS.aspx]<br>
 *  USAGE:
 * <pre>
 *        Weather client = new Weather();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Johannes Eifert
 */
public class Weather {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://api.wxbug.net";

    public Weather() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("getForecastRSS.aspx");
    }

    /**
     * @param responseType Class representing the response
     * @param aCode query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>ZipCode [OPTIONAL]
     * <LI>CityCode [OPTIONAL]
     * <LI>Latitude [OPTIONAL]
     * <LI>Longitude [OPTIONAL]
     * <LI>UnitType [OPTIONAL]
     * <LI>CityType [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T getForecastRSS(Class<T> responseType, String aCode, String... optionalQueryParams) throws UniformInterfaceException {
        return webResource.queryParam("ACode", aCode).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    private MultivaluedMap getQParams(String... optionalParams) {
        MultivaluedMap<String, String> qParams = new com.sun.jersey.api.representation.Form();
        for (String qParam : optionalParams) {
            String[] qPar = qParam.split("=");
            if (qPar.length > 1) {
                qParams.add(qPar[0], qPar[1]);
            }
        }
        return qParams;
    }

    public void close() {
        client.destroy();
    }
    
}
