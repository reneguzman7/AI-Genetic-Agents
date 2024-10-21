package algoritmos_geneticos;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FuncionAptitudEc1 extends FitnessFunction {

    @Override
    protected double evaluate(IChromosome ic) {
        Integer g1 = (Integer)ic.getGene(0).getAllele();
        Integer g2 = (Integer)ic.getGene(1).getAllele();
        Integer g3 = (Integer)ic.getGene(2).getAllele();
        Integer g4 = (Integer)ic.getGene(3).getAllele();
        Integer g5 = (Integer)ic.getGene(4).getAllele();
        Integer g6 = (Integer)ic.getGene(5).getAllele();
        Integer g7 = (Integer)ic.getGene(6).getAllele();
        Integer g8 = (Integer)ic.getGene(7).getAllele();
        Integer g9 = (Integer)ic.getGene(8).getAllele();
        Integer g10 = (Integer)ic.getGene(9).getAllele();

        String x = g2+ "" + g3+ "" + g4 + ""+ g5 + ""; 
        int valor_x = Integer.parseInt(x,2);
        String y = g7+ "" + g8+ "" + g9 + ""+ g10 + ""; 
        int valor_y = Integer.parseInt(y,2);
        int signox = g1;     
        int signoy = g6;     

        if (signox == 0) {
            valor_x = -valor_x;
        }
        if (signoy == 0) {
            valor_y = -valor_y;
        }


        return Math.pow(Math.log(valor_x+valor_y),2);
    }

}
