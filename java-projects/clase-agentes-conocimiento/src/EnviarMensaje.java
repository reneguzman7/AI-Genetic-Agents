import java.io.IOException;
import java.io.Serializable;

import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.core.Agent;
import jade.domain.FIPANames;

public class EnviarMensaje {

    public static void enviarMsj(int tipo, String receptor, Agent agenteEmisor, String contenido, String codigo) {

        ACLMessage mensaje = new ACLMessage(tipo);
        AID id = new AID();
        id.setLocalName(receptor);
        mensaje.addReceiver(id);
        mensaje.setSender(agenteEmisor.getAID());
        mensaje.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        mensaje.setContent(contenido);
        mensaje.setConversationId(codigo);
        agenteEmisor.send(mensaje);
    }

    public static void enviarMsjObject(int tipo, String receptor, Agent agenteEmisor, Serializable contenido,
            String codigo) {

        ACLMessage mensaje = new ACLMessage(tipo);
        AID id = new AID();
        id.setLocalName(receptor);
        mensaje.addReceiver(id);
        mensaje.setSender(agenteEmisor.getAID());
        mensaje.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        try {
            mensaje.setContentObject(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mensaje.setConversationId(codigo);
        agenteEmisor.send(mensaje);
    }

}
