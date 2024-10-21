package agentes;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;

public class Mensaje {
    
    private Mensaje (){}

    public static void sendMSJ(int tipoMsj, String receptor, Agent emisor,
            String conversationID, String contenido, Serializable contenidoObj) {

        ACLMessage aclm = new ACLMessage(0);
        aclm.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        AID aid = new AID();
        aid.setLocalName(receptor);
        aclm.addReceiver(aid);
        aclm.setSender(emisor.getAID());
        aclm.setConversationId(conversationID);

        if (contenido != null) {
            aclm.setContent(contenido);
        } else {
            try {
                aclm.setContentObject(contenidoObj);
            } catch (IOException e) {
                Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        emisor.send(aclm);
    }
}