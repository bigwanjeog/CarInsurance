/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Utilisateur;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
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

    private static Set<Session> sessions = new HashSet<>();//Collections.synchronizedSet(new HashSet<>());

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
        synchronized (sessions) {
            for (Session session : sessions) {
                try {
                    if (!message.isEmpty()) {
                        Gson gson = new GsonBuilder().create();
                        Map<String, String> mapMessage = gson.fromJson(message, new TypeToken<Map<String, String>>(){}.getType());
                        mapMessage.replace("pseudo",escapeHtml4(mapMessage.get("pseudo")));
                        mapMessage.replace("msg",escapeHtml4(MessageChat.lengthMessage(mapMessage.get("msg"))));
                        session.getBasicRemote().sendText(gson.toJson(mapMessage));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(WSChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
