package agente;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente5 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage aclMSJ = blockingReceive();
            System.out.println("Mensaje recibido: " + aclMSJ.getContent());
            Mensajes.send_msj(ACLMessage.INFORM, "Ag1", getAgent(), "cod-5-1", "Hola mi nombre es " + getName(), null);
        }
    }
}