package agentes;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

public class Agente1 extends Agent {
    private String[] ecuaciones;
    boolean bandera = false;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour {
       @Override
       public void action() {
            Ecuaciones ec = (Ecuaciones)getArguments()[0];

            Mensaje.sendMSJ(ACLMessage.INFORM, "Ag2", getAgent(), "ec1", null, ec);
            Mensaje.sendMSJ(ACLMessage.INFORM, "Ag3", getAgent(), "ec2", null, ec);
            Mensaje.sendMSJ(ACLMessage.INFORM, "Ag4", getAgent(), "ec3", null, ec);
            // Mensaje.sendMSJ(ACLMessage.INFORM, "Ag2", getAgent(), "ec1", ecuaciones[0], null);
            // Mensaje.sendMSJ(ACLMessage.INFORM, "Ag3", getAgent(), "ec2", ecuaciones[1], null);
            // Mensaje.sendMSJ(ACLMessage.INFORM, "Ag4", getAgent(), "ec3", ecuaciones[2], null);
            bandera = true;
        }

        @Override
        public boolean done() {
            return bandera;
        }

    }

}
