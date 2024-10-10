package agente;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.Logger;

public class Agente5 extends Agent {

    private Logger logger = Logger.getMyLogger(getClass().getName());


    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage aclMSJ = blockingReceive();

            Mensajes.send_msj(ACLMessage.INFORM, "Ag1", getAgent(), "cod-5-1", "Hola mi nombre es " + getName(), null);
        }
    }
}