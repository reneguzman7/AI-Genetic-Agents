package algoritmos_geneticos;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FuncionAptitudEc3 extends FitnessFunction {

    @Override
    protected double evaluate(IChromosome ic) {
        // valor cromosoma 5
        Integer g1 = (Integer)ic.getGene(0).getAllele();
        Integer g2 = (Integer)ic.getGene(1).getAllele();
        Integer g3 = (Integer)ic.getGene(2).getAllele();
        Integer g4 = (Integer)ic.getGene(3).getAllele();
        Integer g5 = (Integer)ic.getGene(4).getAllele();
      

        String x = g2+ "" + g3+ "" + g4 + ""+ g5 + ""; 
        int valor_x = Integer.parseInt(x,2);
        int signox = g1;     

        if (signox == 0) {
            valor_x = -valor_x;
        }

        return 1 / (1 + Math.exp(-valor_x));
    }

}
