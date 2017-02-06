/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author RENAUD
 */
public class MessageChat {
    
    private static final int LENGTHWORD = 50;
    
    public static String lengthMessage (String message){
        if (message.length() > LENGTHWORD){
            String[] tempMessage = message.split(" ");
            ArrayList<String> tempArray = new ArrayList<>();
            
            for (String mot : tempMessage) {
                tempArray.add(mot);
            }
            
            int cptRound = tempMessage.length;
            
            for (int i = 0; i < cptRound; i++) {
                if(tempArray.get(i).length() > LENGTHWORD){
                    tempArray.add("");
                    String tempMot = tempArray.get(i);
                    String tempDebutMot = tempMot.substring(0, LENGTHWORD);
                    String tempFinMot = tempMot.substring(LENGTHWORD, tempMot.length());
                    tempArray.set(i, tempDebutMot);
                    for(int j = i + 2; j < tempMessage.length + 1; j++){
                        tempArray.set(j,  tempMessage[j - 1]);
                    }
                    tempArray.set(i + 1, tempFinMot);
                    cptRound++;
                }
            }
            String result = "";
            for (String string : tempArray) {
                result += string + " ";
            }
            return result;
        }
        return message;
    }
}
