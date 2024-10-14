package agente;

import java.util.logging.Logger;
import java.util.logging.Level;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Agente3 extends Agent {
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
            try {
                ACLMessage aclMSJ = blockingReceive();
                entrada = (Entrada) aclMSJ.getContentObject();
                entrada.setSensor3(entrada.getSensor3() + 1);
                int sensor3 = entrada.getSensor3();
                System.out.println(" dice: " + sensor3);
                contenedor = (Contenedor) getArguments()[0];
                doDelete();
            } catch (UnreadableException e) {
                Logger.getLogger(Agente3.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            }
        }
    }
}