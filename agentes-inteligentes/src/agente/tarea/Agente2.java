package agente.tarea;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.Logger;

public class Agente2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            // Enviar mensajes a Agente3 y Agente4
            // Mensajes.send_msj(ACLMessage.INFORM, "Ag3", getAgent(),
            //     "cod-2-3", null, new Persona("Agente2", "a Agente 3", "23"));
            

            // Recibir mensajes
            ACLMessage aclMSJ = blockingReceive();
            try {
                Persona p = (Persona) aclMSJ.getContentObject();
                System.out.println("Mensaje recibido de Agente1: " + p);
            } catch (UnreadableException e) {
                Logger.getLogger(Agente2.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        }
    }
}