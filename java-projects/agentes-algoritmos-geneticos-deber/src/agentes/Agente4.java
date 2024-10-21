package agentes;

import algoritmos_geneticos.AGConfiguration;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Agente4 extends Agent {
    private String ecuacion;
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
                ecuacion = acl.getContent();
                new AGConfiguration().configuracionAG();
                // resolver la ecuacion mediante algoritmo genetico
                double valor_optimo = 0;
                String resultado = Double.toString(valor_optimo);
                Mensaje.sendMSJ(ACLMessage.INFORM, "Ag5", getAgent(), "result-ec3", resultado, null);
            }
            bandera = true;
        }

        @Override
        public boolean done() {
            return bandera;
        }

    }

}
