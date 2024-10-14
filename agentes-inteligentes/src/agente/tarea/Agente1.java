
package agente.tarea;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.Logger;

public class Agente1 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            // Enviar mensaje a Agente2
            Mensajes.send_msj(ACLMessage.INFORM, "Ag2", getAgent(),
                "cod-1-2", null, new Persona("Agente1", "a Agente 2", "12"));

            // Recibir mensajes
            ACLMessage aclMSJ = blockingReceive();
            try {
                Persona p = (Persona) aclMSJ.getContentObject();
                System.out.println(p);
            } catch (UnreadableException e) {
                Logger.getLogger(Agente1.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        }
    }
}