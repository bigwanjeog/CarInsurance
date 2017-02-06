/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import bean.Constructeur;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ConstructeurFacadeREST
 * [entity.constructeur]<br>
 * USAGE:
 * <pre>
 *        JerseyConstructeur client = new JerseyConstructeur();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author RENAUD
 */
public class JerseyConstructeur {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WebServiceCarInsurance/webresources";

    public JerseyConstructeur() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entity.constructeur");
    }
    
    public String countREST() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public String findAll() throws ClientErrorException {
        WebTarget resource = webTarget;
        String json = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        return json;
    }
    
    public void close() {
        client.close();
    }
}
