package agente;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Agente1 extends Agent {
    boolean bandera = false;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour {
        @Override
        public void action() {
            Mensajes.send_msj(ACLMessage.INFORM, "Ag2", getAgent(), "cod-1-2", "Hola mi nombre es" + getName(), null);
            // Mensajes.send_msj(ACLMessage.INFORM, "Ag2", getAgent(),
            //  "cod-1-2", null, new Persona("Juan", "Perez", "25"));	
            bandera = true;
        }

        @Override
        public boolean done() {
            return bandera;
        }
    }
}
