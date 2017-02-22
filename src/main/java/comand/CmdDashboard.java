/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import bean.Utilisateur;
import bean.Voiture;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tool.DoubleRound;
import tool.PasswordMD5;
import webservice.JerseyUtilisateur;
import webservice.JerseyVoiture;
import webservice.SOAPClient;

/**
 *
 * @author RENAUD
 */
public class CmdDashboard implements IComand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Utilisateur util = (Utilisateur) session.getAttribute("utilisateur");
        Utilisateur utilTemp = (Utilisateur) session.getAttribute("utilisateurTemp");
        String status = request.getParameter("status");
        
        String url = "WEB-INF/home.jsp";
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        JerseyUtilisateur ju = new JerseyUtilisateur();

        if (utilTemp != null && email == null) {
            String idVoiture = request.getParameter("selectVoiture");
            if (idVoiture.equals("null")) {
                request.setAttribute("voitureNull", "Veuillez sélectionner une voiture");
                url = "WEB-INF/voiture.jsp";
            } else {
                JerseyVoiture jv = new JerseyVoiture();
                Voiture voiture = jv.find(Voiture.class, idVoiture);
                utilTemp.setVoiture(voiture);
                double prix = SOAPClient.price(utilTemp.getDateNaissance(), voiture.getAnnee(), voiture.getCarburant(), voiture.getChevaux());
                utilTemp.setPrix(DoubleRound.round(prix));
                
                ju.create(utilTemp);
                session.removeAttribute("utilisateurTemp");
                session.setAttribute("utilisateur", ju.findByEmail(utilTemp.getEmail()).get(0));
                url = "WEB-INF/dashboard.jsp";
            }
        } else if (util == null) {
            if (email != null && !email.equals("") && password != null && !password.equals("")) {
                List<Utilisateur> utilSignIn = ju.findByEmail(email);
                if (!utilSignIn.isEmpty()) {
                    if (PasswordMD5.encodePassword(password).equals(utilSignIn.get(0).getPassword())) {
                        session.setAttribute("utilisateur", utilSignIn.get(0));
                        url = "WEB-INF/dashboard.jsp";
                    } else {
                        request.setAttribute("mdpErreur", "Le mot de passe ne correspond pas");
                        request.setAttribute("emailCorrect", email);
                    }
                } else {
                    request.setAttribute("emailErreur", "Email inexistant");
                }
            } else {
                request.setAttribute("connexionErreur", "Veuillez remplir les champs pour vous connecter");
            }
        } else if (status != null) {
            String idVoiture = request.getParameter("selectVoiture");
            if (idVoiture.equals("null")) {
                request.setAttribute("voitureNull", "Veuillez sélectionner une voiture");
                url = "WEB-INF/voiture.jsp";
            } else {
                JerseyVoiture jv = new JerseyVoiture();
                Voiture voiture = jv.find(Voiture.class, idVoiture);
                util.setVoiture(voiture);
                double prix = SOAPClient.price(util.getDateNaissance(), voiture.getAnnee(), voiture.getCarburant(), voiture.getChevaux());
                util.setPrix(DoubleRound.round(prix));
                ju.edit(util, String.valueOf(util.getId()));
                session.setAttribute("utilisateur", util);
                url = "WEB-INF/dashboard.jsp";
            }
        } else {
            url = "WEB-INF/dashboard.jsp";
        }
        return url;
    }

}
