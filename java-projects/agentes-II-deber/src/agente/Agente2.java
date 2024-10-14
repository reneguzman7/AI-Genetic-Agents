package agente;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    String alias = "Ag3";

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage aclMSJ = blockingReceive(); 
            

            Entrada entrada = (Entrada)getArguments()[0]; 
            
            Mensajes.send_msj(ACLMessage.INFORM, alias, getAgent(), "cod-2-3", null, entrada);
            Mensajes.send_msj(ACLMessage.INFORM, "Ag4", getAgent(), "cod-2-4", "Hola mi nombre es " + getName(), null);
            

        }
    }
}