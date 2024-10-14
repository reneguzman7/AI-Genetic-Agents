import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteHijo extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());

    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            System.out.println(getAgent());
            Entrada entrada = (Entrada) getArguments()[0];
            System.out.println(entrada.getSensor3());
            entrada.setSensor3(entrada.getSensor3() + 1);
            EnviarMensaje.enviarMsjObject(ACLMessage.INFORM, "Ag1", getAgent(), entrada, "codigo");
            ACLMessage acl = blockingReceive();


        }

    }

}
