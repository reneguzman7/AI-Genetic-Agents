package agente;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

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
            ACLMessage acl = blockingReceive();
            Entrada entrada = null;
            try {
                entrada = (Entrada) acl.getContentObject();
            } catch (UnreadableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println();
            
            Mensajes.send_msj(ACLMessage.INFORM, "Ag4", getAgent(), "cod-hijo-4", null, entrada);
            contenedor = (Contenedor) getArguments()[0];
            
            doDelete();


        }

    }

}
