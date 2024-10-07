package Agente;
import java.lang.System.Logger;
import java.util.logging.Level;

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
            agentContainer.createNewAgent("Ag1", Agente1.class.getName(), null.start());    
        } catch (Exception e) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
}
