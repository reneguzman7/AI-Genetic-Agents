import java.util.logging.Level;
import java.util.logging.Logger;

import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;

public class Contenedor {

    static AgentContainer agentContainer;

    public void configurarContenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        ProfileImpl profile = new ProfileImpl(null, 1099, null);
        agentContainer = runtime.createMainContainer(profile);
        iniciarAgentes();

    }

    private void iniciarAgentes() {
        try {
            agentContainer.createNewAgent("Ag1", Agente1.class.getName(),
                    new Object[] { new Entrada("v1", "v2", "v3", "v4", "v5", 1) }).start();
            agentContainer.createNewAgent("Ag3", Agente3.class.getName(), new Object[] { this }).start();

        } catch (Exception e) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void crearHijos(Object conocimiento) {
        try {
            agentContainer.createNewAgent("AgHijo", AgenteHijo.class.getName(), new Object[] { conocimiento }).start();

        } catch (Exception e) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        contenedor.configurarContenedor();
    }
}
