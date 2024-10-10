// package agente;

// import jade.core.Agent;
// import jade.core.behaviours.CyclicBehaviour;
// import jade.lang.acl.ACLMessage; 
// import jade.lang.acl.UnreadableException;
// import jade.util.Logger;

// public class Agente2 extends Agent {

//     @Override
//     protected void setup() {
//         addBehaviour(new Comportamiento());
//     }

//     class Comportamiento extends CyclicBehaviour {
//         @Override
//         public void action() {
//             ACLMessage aclMSJ = blockingReceive();
//             Mensajes.send_msj(ACLMessage.INFORM, "Ag2", getAgent(), "cod-2-3", "Hola mi nombre es" + getName(), null);
//             Mensajes.send_msj(ACLMessage.INFORM, "Ag4", getAgent(), "cod-2-4", "Hola mi nombre es" + getName(), null);

//             // Mensajes.send_msj(ACLMessage.INFORM, "Ag2", getAgent(), "cod-1-2", "Hola mi nombre es" + getName(), null);
//             // try {
//             //     Persona p = (Persona)aclMSJ.getContentObject();
//             //     System.out.println(p); 
//             // } catch (UnreadableException e) {
//             //     Logger.getLogger(Agente2.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
//             // }
//         }  
//     }
// }


package agente;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage; 
import jade.util.Logger;

public class Agente2 extends Agent {
    private Logger logger = Logger.getMyLogger(getClass().getName());

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
        logger.log(Logger.INFO, "Agente2 iniciado");
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage aclMSJ = blockingReceive();
            if (aclMSJ != null) {
                logger.log(Logger.INFO, "Mensaje recibido: " + aclMSJ.getContent());
                Mensajes.send_msj(ACLMessage.INFORM, "Ag3", getAgent(), "cod-2-3", "Hola mi nombre es " + getName(), null);
                Mensajes.send_msj(ACLMessage.INFORM, "Ag4", getAgent(), "cod-2-4", "Hola mi nombre es " + getName(), null);
            } else {
                logger.log(Logger.WARNING, "No se recibió ningún mensaje");
            }
        }  
    }
}