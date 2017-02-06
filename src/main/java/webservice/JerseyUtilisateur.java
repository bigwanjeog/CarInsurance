/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import bean.Utilisateur;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UtilisateurFacadeREST
 * [entity.utilisateur]<br>
 * USAGE:
 * <pre>
 *        JerseyUtilisateur client = new JerseyUtilisateur();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author RENAUD
 */
public class JerseyUtilisateur {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WebServiceCarInsurance/webresources";

    public JerseyUtilisateur() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entity.utilisateur");
    }
    
    public List<Utilisateur> findByCP(String cp) throws ClientErrorException {        
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("cp/{0}", new Object[]{cp}));
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }

    public void edit(Object requestEntity, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T findRange(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public List<Utilisateur> findByAdress(String adress) throws ClientErrorException {        
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("adress/{0}", new Object[]{adress}));
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }

    public List<Utilisateur> findByName(String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("name/{0}", new Object[]{name}));
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }

    public List<Utilisateur> findByBirthday(String birthday) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("birthday/{0}", new Object[]{birthday}));
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }

    public void remove(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    public List<Utilisateur> findByFunction(String function) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("function/{0}", new Object[]{function}));
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }

    public String countREST() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public List<Utilisateur> findBySurname(String surname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("surname/{0}", new Object[]{surname}));
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }

    public List<Utilisateur> findByCity(String city) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("city/{0}", new Object[]{city}));
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }

    public <T> T find(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void create(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public List<Utilisateur> findByEmail(String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("email/{0}", new Object[]{email}));
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }
    
    public List<Utilisateur> findAll() throws ClientErrorException {
        WebTarget resource = webTarget;
        List<Utilisateur> utilisateurs;
        String string = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new GsonBuilder().create();
        utilisateurs = gson.fromJson(string, new TypeToken<List<Utilisateur>>(){}.getType());
        return utilisateurs;
    }

    public void close() {
        client.close();
    }
    
}
