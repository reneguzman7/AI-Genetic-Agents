package algoritmos_geneticos;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class AGConfiguration {

    private int tamanioCromosoma = 10; 
    private int tamanioPoblacion = 3; // de 5 en 5. si pongo mas individuos converge mas rapido
    private int numeroGeneraciones = 10;
    private int numeroEvoluciones = 3;

    public void configuracionAG() {
        try {
            Configuration configuracion = new DefaultConfiguration();
            configuracion.setFitnessFunction(new FuncionAptitudEc1());

            Gene[] ejemplo = new Gene[tamanioCromosoma];
            ejemplo = generarGenEjemplo(ejemplo, configuracion);
            Chromosome cromosoma = new Chromosome(configuracion, ejemplo);
            configuracion.setPopulationSize(tamanioPoblacion);
            configuracion.setSampleChromosome(cromosoma);
            evolucionPoblacion(configuracion);

        } catch (InvalidConfigurationException e) {
            Logger.getLogger(AGConfiguration.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private void verTodosIndividuos(IChromosome[] ics) {
        for (IChromosome ic : ics) {
            verIndividuo(ic);
        }
    }

    private void verIndividuo(IChromosome ic) {
        Integer g1 = (Integer) ic.getGene(0).getAllele();
        Integer g2 = (Integer) ic.getGene(1).getAllele();
        Integer g3 = (Integer) ic.getGene(2).getAllele();
        Integer g4 = (Integer) ic.getGene(3).getAllele();
        Integer g5 = (Integer) ic.getGene(4).getAllele();
        Integer g6 = (Integer) ic.getGene(5).getAllele();
        Integer g7 = (Integer) ic.getGene(6).getAllele();
        Integer g8 = (Integer) ic.getGene(7).getAllele();
        Integer g9 = (Integer) ic.getGene(8).getAllele();
        Integer g10 = (Integer) ic.getGene(9).getAllele();

        String x = g2 + "" + g3 + "" + g4 + "" + g5 + "";
        int valor_x = Integer.parseInt(x, 2);
        String y = g7 + "" + g8 + "" + g9 + "" + g10 + "";
        int valor_y = Integer.parseInt(y, 2);
        int signox = g1;
        int signoy = g6;

        if (signox == 0) {
            valor_x = -valor_x;
        }
        if (signoy == 0) {
            valor_y = -valor_y;
        }
        Logger.getLogger(valor_x + " " + valor_y);
    }

    private void evolucionPoblacion(Configuration configuracion) {
        try {
            Genotype poblacionInicial = Genotype.randomInitialGenotype(configuracion);
            for (int i = 0; i < numeroGeneraciones; i++) {
                Logger.getLogger("****** Poblacion " + i + " ****");
                verTodosIndividuos(poblacionInicial.getChromosomes());
                Logger.getLogger("__________________________________");
                poblacionInicial.evolve(numeroEvoluciones);
                IChromosome mejorGeneracion = poblacionInicial.getFittestChromosome();
                verIndividuo(mejorGeneracion);
                Logger.getLogger("******************************");

            }

            IChromosome mejorIndividuo = poblacionInicial.getFittestChromosome();
            Logger.getLogger("************ Mejor individuo **********");
            verIndividuo(mejorIndividuo);
        } catch (InvalidConfigurationException e) {
            Logger.getLogger(AGConfiguration.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private Gene[] generarGenEjemplo(Gene[] genes, Configuration configuracion) {

        for (int i = 0; i < tamanioCromosoma; i++) {
            try {
                genes[i] = new IntegerGene(configuracion, 0, 1);
            } catch (InvalidConfigurationException e) {
                Logger.getLogger(AGConfiguration.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return genes;
    }

}
