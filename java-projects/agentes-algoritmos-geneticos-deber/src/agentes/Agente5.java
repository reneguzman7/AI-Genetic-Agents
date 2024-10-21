package agentes;

import java.util.logging.Logger;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Agente5 extends Agent {

    boolean bandera = false;

    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour {

                @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            if (acl != null) {
                String contenido = acl.getContent();
                Logger.getLogger(Agente5.class.getName()).info("Mensaje recibido: " + contenido);
                String[] valoresOptimos = contenido.split(",");
                for (int i = 0; i < valoresOptimos.length; i++) {
                    Logger.getLogger(Agente5.class.getName()).info("Resultado recibido ecuacion " + (i + 1) + ": " + valoresOptimos[i]);
                }
            }
            bandera = true;
        }

        @Override
        public boolean done() {
            return bandera;
        }

    }

}
