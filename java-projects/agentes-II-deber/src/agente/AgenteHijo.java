package agente;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteHijo extends Agent {
    Contenedor contenedor;
    Entrada entrada;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());

    }

    @Override
    protected void takeDown() {
        contenedor.crearHijos(entrada);
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            System.out.println(getAgent());
            entrada = (Entrada) getArguments()[0];
            System.out.println(entrada.getSensor3());
            entrada.setSensor3(entrada.getSensor3() + 1);
            Mensajes.send_msj(ACLMessage.INFORM, "Ag4", getAgent(), "cod-hijo-4", null, entrada);
            contenedor = (Contenedor) getArguments()[0];
            ACLMessage acl = blockingReceive();
            doDelete();


        }

    }

}
