/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Utilisateur;
import comand.CmdChat;
import comand.CmdDashboard;
import comand.CmdFormulaire;
import comand.CmdHome;
import comand.CmdLogout;
import comand.CmdVoiture;
import comand.IComand;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tool.GetPseudo;
import tool.SelectVoiture;

/**
 *
 * @author RENAUD
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Map comands = new HashMap();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cmd = request.getParameter("page");
        String resultat = request.getParameter("resultat");
        String requestPseudo = request.getParameter("request");

        if (resultat != null) {
            SelectVoiture.selectVoiture(resultat, request, response);
        } else if (requestPseudo != null) {
            GetPseudo.getPseudo(request, response);
        } else {
            IComand comand;
            HttpSession session = request.getSession();
            Utilisateur util = (Utilisateur) session.getAttribute("utilisateur");
            if (cmd == null) {
                if (util == null) {
                    comand = (IComand) comands.get("home");
                } else {
                    session.removeAttribute("utilisateurTemp");
                    comand = (IComand) comands.get("dashboard");
                }
            } else {
                comand = (IComand) comands.get(cmd);
            }
            String url = comand.execute(request, response);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    public void init() {
        comands.put("home", new CmdHome());
        comands.put("formulaire", new CmdFormulaire());
        comands.put("chat", new CmdChat());
        comands.put("voiture", new CmdVoiture());
        comands.put("dashboard", new CmdDashboard());
        comands.put("logout", new CmdLogout());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
