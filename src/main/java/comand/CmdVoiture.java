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
import tool.PasswordMD5;
import tool.ValidatorBean;
import webservice.JerseyUtilisateur;

/**
 *
 * @author RENAUD
 */
public class CmdVoiture implements IComand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Utilisateur util = (Utilisateur) session.getAttribute("utilisateur");

        String url = "WEB-INF/dashboard.jsp";

        if (util == null) {
            String nom = request.getParameter("inputNom");
            if (nom != null) {
                String prenom = request.getParameter("inputPrenom");
                String adresse = request.getParameter("inputAdresse");
                String ville = request.getParameter("inputVille");
                String cp = request.getParameter("inputCP");
                String dateNaissance = request.getParameter("inputDateNaissance");
                String email = request.getParameter("inputEmail");
                String password = PasswordMD5.encodePassword(request.getParameter("inputPassword"));
                String confirmation = PasswordMD5.encodePassword(request.getParameter("inputConfirmation"));

                Utilisateur utilisateur = new Utilisateur(nom, prenom, adresse, ville, cp, dateNaissance, email, password, "client");

                if (password.equals(confirmation) && ValidatorBean.validatorBean(utilisateur)) {
                    JerseyUtilisateur ju = new JerseyUtilisateur();
                    List<Utilisateur> utilisateurCheckEmail = ju.findByEmail(email);
                    if (utilisateurCheckEmail.isEmpty()) {
                        session.setAttribute("utilisateurTemp", utilisateur);
                        request.setAttribute("pageVoiture", true);
                        url = "WEB-INF/voiture.jsp";
                    } else {
                        request.setAttribute("signInNom", nom);
                        request.setAttribute("signInPrenom", prenom);
                        request.setAttribute("signInAdresse", adresse);
                        request.setAttribute("signInVille", ville);
                        request.setAttribute("signInCp", cp);
                        request.setAttribute("signInDateNaissance", dateNaissance);
                        request.setAttribute("signInMdp", request.getParameter("inputPassword"));
                        request.setAttribute("signInConfirmation", request.getParameter("inputConfirmation"));
                        request.setAttribute("errorEmail", "Email déjà existant");
                        url = "WEB-INF/formulaire.jsp";
                    }
                } else {
                    url = "WEB-INF/error.jsp";
                }
            } else {
                url = "WEB-INF/home.jsp";
            }
        }
        return url;
    }
}
