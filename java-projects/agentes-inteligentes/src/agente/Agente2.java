package agente;

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
            ACLMessage aclMSJ = blockingReceive();
            try {
                Persona p = (Persona)aclMSJ.getContentObject();
                System.out.println(p); 
            } catch (UnreadableException e) {
                Logger.getLogger(Agente2.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        }  
    }
}