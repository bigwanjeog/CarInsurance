/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import com.google.gson.Gson;
import bean.Constructeur;
import bean.Modele;
import bean.Voiture;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.JerseyConstructeur;
import webservice.JerseyModele;
import webservice.JerseyVoiture;

/**
 *
 * @author RENAUD
 */
public class SelectVoiture {

    public static void selectVoiture(String resultat, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String json = "";
        if (resultat.equals("constructeur")) {
            JerseyConstructeur jc = new JerseyConstructeur();
            json = jc.findAll();

        } else if (resultat.equals("modele")) {
            JerseyModele jm = new JerseyModele();
            String idConstructeur = request.getParameter("modele");
            json = jm.findByManufacturer(idConstructeur);

        } else if (resultat.equals("voiture")) {
            JerseyVoiture jv = new JerseyVoiture();
            String idModele = request.getParameter("voiture");
            json = jv.findByModele(idModele);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
