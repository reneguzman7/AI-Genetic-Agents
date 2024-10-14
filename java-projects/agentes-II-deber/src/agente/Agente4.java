package agente;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente4 extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage aclMSJ = blockingReceive();
                System.out.println("Mensaje recibido: " + getLocalName()+ aclMSJ.getContent());

           
            Mensajes.send_msj(ACLMessage.INFORM, "Ag5", getAgent(), "cod-4-5", "Hola mi nombre es " + getName(), null);
        }
    }
}