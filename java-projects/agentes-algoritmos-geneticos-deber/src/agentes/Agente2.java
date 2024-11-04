package agentes;

import java.util.logging.Level;
import java.util.logging.Logger;

import algoritmos_geneticos.FuncionAptitudEc1;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class Agente2 extends Agent {
    private String ecuacion;
    boolean bandera = false;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour {

        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            if (acl != null) {
                try {
                    Ecuaciones ecuaciones = (Ecuaciones) acl.getContentObject();
                    ecuacion = ecuaciones.getEcuacion1(); 
                    
                    Configuration configuracion = new DefaultConfiguration();
                    configuracion.setFitnessFunction(new FuncionAptitudEc1());

                    int tamanioCromosoma = 10;
                    int tamanioPoblacion = 3;
                    int numeroGeneraciones = 5;
                    int numeroEvoluciones = 1;

                    Gene[] ejemplo = new Gene[tamanioCromosoma];
                    for (int i = 0; i < tamanioCromosoma; i++) {
                        ejemplo[i] = new IntegerGene(configuracion, 0, 1);
                    }
                    Chromosome cromosoma = new Chromosome(configuracion, ejemplo);
                    configuracion.setPopulationSize(tamanioPoblacion);
                    configuracion.setSampleChromosome(cromosoma);

                    
                    Genotype poblacionInicial = Genotype.randomInitialGenotype(configuracion);
                    for (int i = 0; i < numeroGeneraciones; i++) {
                        poblacionInicial.evolve(numeroEvoluciones);
                    }
                    IChromosome mejorIndividuo = poblacionInicial.getFittestChromosome();
                    int valor_optimo = (Integer) mejorIndividuo.getGene(0).getAllele();

                    String resultado = Integer.toString(valor_optimo);
                    Mensaje.sendMSJ(ACLMessage.INFORM, "Ag5", getAgent(), "result-ec1", resultado, null);
                } catch (UnreadableException | InvalidConfigurationException e) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, e);
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