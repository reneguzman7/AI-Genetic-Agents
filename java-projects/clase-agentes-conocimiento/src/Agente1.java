import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente1 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    String alias = "Ag3";

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            Entrada entrada = (Entrada)getArguments()[0]; 
            // System.out.println(entrada );
            EnviarMensaje.enviarMsjObject(ACLMessage.INFORM, alias, getAgent(), entrada, "codigo");
            ACLMessage acl = blockingReceive();
            alias = acl.getSender().getLocalName();
            
        }
    }

}
