package agentes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente5 extends Agent {

    private final List<String> resultados = new ArrayList<>(3);
    private final Logger logger = Logger.getLogger(Agente5.class.getName());

    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            ACLMessage mensaje = blockingReceive();

            if (mensaje != null) {
                String contenido = mensaje.getContent();
                String agenteRemitente = mensaje.getSender().getLocalName();
                logger.info("Mensaje recibido de " + agenteRemitente + ": " + contenido);

                switch (agenteRemitente) {
                    case "Ag2":
                        agregarResultado(0, contenido);
                        break;
                    case "Ag3":
                        agregarResultado(1, contenido);
                        break;
                    case "Ag4":
                        agregarResultado(2, contenido);
                        break;
                    default:
                        logger.warning("Mensaje de agente desconocido: " + agenteRemitente);
                        break;
                }

                if (resultadosCompletos()) {
                    imprimirResultados();
                    resultados.clear();
                }
            }
        }

        private void agregarResultado(int indice, String valor) {
            while (resultados.size() <= indice) {
                resultados.add(null);
            }
            resultados.set(indice, valor);
        }

        private boolean resultadosCompletos() {
            return resultados.size() == 3 && !resultados.contains(null);
        }

        private void imprimirResultados() {
            logger.info("Resultados completos recibidos:");
            for (int i = 0; i < resultados.size(); i++) {
                logger.info("Ecuación " + (i + 1) + ": " + resultados.get(i));
            }
        }
    }
}
