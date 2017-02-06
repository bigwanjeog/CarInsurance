/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import bean.Modele;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ModeleFacadeREST
 * [entity.modele]<br>
 * USAGE:
 * <pre>
 *        JerseyModele client = new JerseyModele();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author RENAUD
 */
public class JerseyModele {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WebServiceCarInsurance/webresources";

    public JerseyModele() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entity.modele");
    }

    
    public String countREST() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }
    
    public String findByManufacturer(String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("manufacturer/{0}", new Object[]{id}));
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        return string;
    }

    public <T> T find(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public List<Modele> findAll() throws ClientErrorException {
        WebTarget resource = webTarget;
        List<Modele> modeles;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        modeles = gson.fromJson(string, new TypeToken<List<Modele>>(){}.getType());
        return modeles;
    }

    public void close() {
        client.close();
    }
    
}
