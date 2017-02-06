/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;
import tool.MessageChat;

/**
 *
 * @author RENAUD
 */
@ServerEndpoint("/chat")
public class WSChat {

    private static Set<Session> sessions = new HashSet<>();
//Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println(error);
    }

    @OnMessage
    public String onMessage(String message) {
        synchronized (sessions){
            for (Session session : sessions) {
                try {
                    if(!message.isEmpty()){
                        message = MessageChat.lengthMessage(message);
                        session.getBasicRemote().sendText(escapeHtml4(message));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(WSChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
