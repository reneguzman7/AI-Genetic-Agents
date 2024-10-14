package agente;

import java.util.logging.Level;
import java.util.logging.Logger;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Agente4 extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage aclMSJ = blockingReceive();
            try {
                System.out.println("Mensaje recibido: " + aclMSJ.getContentObject());
            } catch (UnreadableException e) {
                Logger.getLogger(Agente3.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            System.out.println("Mensaje recibido: " + aclMSJ.getContent());
            Mensajes.send_msj(ACLMessage.INFORM, "Ag5", getAgent(), "cod-4-5", "Hola mi nombre es " + getName(), null);
        }
    }
}