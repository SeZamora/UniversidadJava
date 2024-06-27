package gt.com.sga.cliente;

import gt.com.sga.domain.Persona;
import gt.com.sga.servicio.PersonaServiceRemote;
import javax.naming.*;
import org.apache.logging.log4j.*;


public class PruebaManejoTransacciones {
     static Logger log = LogManager.getRootLogger();
     public static void main(String[] args) {
          try {
               Context jndi = new  InitialContext();
               PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/SGA_JPA_WEB/PersonaServiceImpl!gt.com.sga.servicio.PersonaServiceRemote");
               
               log.debug("Iniciando prueba manejo transaccional manejo PersonaService");
               
               //Buscar una persona
               Persona persona = personaService.encontrarPersonaId(new Persona(1));
               log.debug("Persona Recuperada: "+persona);
               
               //Cambiar el apellido de la persona
               //error
               //persona.setApellido("cambioooooooooooooooooooerooooooooorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrreee");
               persona.setApellido("Perez");
               personaService.modificarPersona(persona);
               log.debug("Objeto modificado persona: "+persona);
               log.debug("Fin de prueba");
          } catch (NamingException ex) {
               log.debug(ex.getMessage());
          }
     }
}
