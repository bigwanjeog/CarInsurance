/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import bean.Utilisateur;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RENAUD
 */
public class CmdFormulaire implements IComand {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Utilisateur util = (Utilisateur) session.getAttribute("utilisateur");

        String url = "WEB-INF/dashboard.jsp";

        if (util == null) {
            url = "WEB-INF/formulaire.jsp";
        }
        return url;
    }

}
