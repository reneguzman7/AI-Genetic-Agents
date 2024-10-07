package Agente;
import jade.core.Agent;

public class Agente1 extends Agent {
    @Override
    protected void setup() {
        System.out.println(getName());
    }
}
