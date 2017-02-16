/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RENAUD
 */
public class SOAPClient {
    public static double price(String date, String annee, String carburant, String chevaux){
        double price = 0;
        try {
            CarInsurancePrice_Service service = new CarInsurancePrice_Service();
            CarInsurancePrice port = service.getCarInsurancePricePort();
            price = port.prix(date, annee, carburant, chevaux);
        } catch (Exception ex) {
            Logger logger = Logger.getLogger(SOAPClient.class.getName());
            logger.log(Level.SEVERE, "Erreur dans les parametres");
        }
        return price;
    }
}
