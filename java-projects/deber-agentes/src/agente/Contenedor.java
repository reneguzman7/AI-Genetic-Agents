package agente;
import java.util.logging.Level;
import java.util.logging.Logger;


import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;

public class Contenedor {

    static AgentContainer agentContainer;


    public static void configurarContenedor(){
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        ProfileImpl profile = new ProfileImpl(null,1099,null);
        agentContainer = runtime.createMainContainer(profile);
        agregarAgentes();
        
    }
    private static void agregarAgentes() {
        try {
            agentContainer.createNewAgent("Ag5", Agente5.class.getName(), null).start();
            agentContainer.createNewAgent("Ag4", Agente4.class.getName(), null).start();
            agentContainer.createNewAgent("Ag3", Agente3.class.getName(), null).start();
            agentContainer.createNewAgent("Ag1", Agente1.class.getName(), null).start();   
            agentContainer.createNewAgent("Ag2", Agente2.class.getName(), null).start(); 
        } catch (Exception e) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
}
