package agente;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

public class Agente1 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            Mensajes.send_msj(ACLMessage.INFORM, "Ag2", getAgent(), "cod-1-2", "Hola mi nombre es " + getName(),null);
            ACLMessage aclMSJ = blockingReceive();

        }
    }
}