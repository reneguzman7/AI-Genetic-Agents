package agente;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

public class Mensajes {
    public static void send_msj(int tipoMsj, String receptor, Agent emisor,
            String conversationID, String contenido, Serializable contenidoObj) {
        // Serializacion: convertir un objeto a bytes para viajar por el bus

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
            // Serializacion
            try {
                aclm.setContentObject(contenidoObj);
            } catch (IOException e) {
                Logger.getLogger(Mensajes.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        emisor.send(aclm);
    }

}
