package agente;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

public class Agente2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage aclMSJ = blockingReceive();

            System.out.println("Mensaje recibido: " + aclMSJ.getContent());
            Mensajes.send_msj(ACLMessage.INFORM, "Ag3", getAgent(), "cod-2-3", "Hola mi nombre es " + getName(), null);
            Mensajes.send_msj(ACLMessage.INFORM, "Ag4", getAgent(), "cod-2-4", "Hola mi nombre es " + getName(), null);

        }
    }
}