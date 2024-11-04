package agentes;

import java.util.logging.Level;
import java.util.logging.Logger;

import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;

public class Contenedor {

    static AgentContainer agentContainer;

    public void configurarContenedor(){
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        ProfileImpl profile = new ProfileImpl(null,1099,null);
        agentContainer = runtime.createMainContainer(profile);
        agregarAgentes();
    }

    private void agregarAgentes( ){
        try {
            agentContainer.createNewAgent("Ag5", Agente5.class.getName(), null).start();
            agentContainer.createNewAgent("Ag2", Agente2.class.getName(), null).start();
            agentContainer.createNewAgent("Ag3", Agente3.class.getName(), null).start();
            agentContainer.createNewAgent("Ag4", Agente4.class.getName(), null).start();
            agentContainer.createNewAgent("Ag1", Agente1.class.getName(), new Object[] {new Ecuaciones("Math.pow(Math.log(x+y),2)",
        "Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) / (x + y)",
        "1 / (1 + Math.exp(-1))")}).start();
        } catch (Exception e) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
