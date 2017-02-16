/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import bean.Utilisateur;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ClientErrorException;
import tool.DoubleRound;
import tool.PasswordMD5;
import tool.ValidatorBean;
import webservice.JerseyUtilisateur;
import webservice.SOAPClient;

/**
 *
 * @author RENAUD
 */
public class CmdVoiture implements IComand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Utilisateur util = (Utilisateur) session.getAttribute("utilisateur");
        String status = request.getParameter("status");

        String url = "WEB-INF/dashboard.jsp";

        String nom = request.getParameter("inputNom");
        String prenom = request.getParameter("inputPrenom");
        String adresse = request.getParameter("inputAdresse");
        String ville = request.getParameter("inputVille");
        String cp = request.getParameter("inputCP");
        String dateNaissance = request.getParameter("inputDateNaissance");
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        String confirmation = request.getParameter("inputConfirmation");

        JerseyUtilisateur ju = new JerseyUtilisateur();

        if (util == null) {
            if (nom != null) {
                Utilisateur utilisateur = new Utilisateur(nom, prenom, adresse, ville, cp, dateNaissance, email, PasswordMD5.encodePassword(password), "client");
                if (password.equals(confirmation) && ValidatorBean.validatorBean(utilisateur)) {
                    List<Utilisateur> utilisateurCheckEmail = ju.findByEmail(email);
                    if (utilisateurCheckEmail.isEmpty()) {
                        session.setAttribute("utilisateurTemp", utilisateur);
                        url = "WEB-INF/voiture.jsp";
                    } else {
                        url = emailFailed(request, nom, prenom, adresse, ville, cp, dateNaissance, password, confirmation);
                    }
                } else {
                    url = "WEB-INF/error.jsp";
                }
            } else {
                url = "WEB-INF/home.jsp";
            }
        } else if (status != null) {
            if (nom != null) {
                if (!util.getPassword().equals(password)) {
                    password = PasswordMD5.encodePassword(password);
                }
                util.setNom(nom);
                util.setPrenom(prenom);
                util.setAdresse(adresse);
                util.setVille(ville);
                util.setCp(cp);
                util.setDateNaissance(dateNaissance);
                util.setEmail(email);
                util.setPassword(password);
                if (password.equals(confirmation) && ValidatorBean.validatorBean(util)) {
                    double prix = SOAPClient.price(dateNaissance, util.getVoiture().getAnnee(), util.getVoiture().getCarburant(), util.getVoiture().getChevaux());
                    util.setPrix(DoubleRound.round(prix));
                    if (util.getEmail().equals(email)) {
                        url = updateUtilisateur(ju, util, session);
                    } else {
                        List<Utilisateur> utilisateurCheckEmail = ju.findByEmail(email);
                        if (utilisateurCheckEmail.isEmpty()) {
                            url = updateUtilisateur(ju, util, session);
                        } else {
                            url = emailFailed(request, nom, prenom, adresse, ville, cp, dateNaissance, password, confirmation);
                        }
                    }
                } else {
                    url = "WEB-INF/error.jsp";
                }
            } else {
                url = "WEB-INF/voiture.jsp";
            }
        }
        return url;
    }

    private String updateUtilisateur(JerseyUtilisateur ju, Utilisateur utilisateur, HttpSession session) throws ClientErrorException {
        ju.edit(utilisateur, String.valueOf(utilisateur.getId()));
        session.setAttribute("utilisateur", utilisateur);
        return "WEB-INF/dashboard.jsp";
    }

    private String emailFailed(HttpServletRequest request, String nom, String prenom, String adresse, String ville, String cp, String dateNaissance, String password, String confirmation) {
        request.setAttribute("signInNom", nom);
        request.setAttribute("signInPrenom", prenom);
        request.setAttribute("signInAdresse", adresse);
        request.setAttribute("signInVille", ville);
        request.setAttribute("signInCp", cp);
        request.setAttribute("signInDateNaissance", dateNaissance);
        request.setAttribute("signInMdp", password);
        request.setAttribute("signInConfirmation", confirmation);
        request.setAttribute("errorEmail", "Email déjà existant");
        return "WEB-INF/formulaire.jsp";
    }
}
