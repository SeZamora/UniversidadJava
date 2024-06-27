package gt.com.sga.cliente;

import gt.com.sga.domain.Persona;
import gt.com.sga.servicio.PersonaServiceRemote;
import java.util.List;
import javax.naming.*;


public class ClientePersonaService {

    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el Cliente");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/SgaJEE/PersonaServiceImpl");

            List<Persona> personas = personaService.listarPersonas();
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            System.out.println("\n Fin de la llamada al EJB desde el cliente");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
