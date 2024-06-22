package gt.com.sga.servicio;

import gt.com.sga.domain.Persona;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface PersonaServiceRemote {
    
    public List<Persona> listarPersonas();
    
   public Persona encontrarPersonaId(Persona persona);
   
   public Persona encontrarPersonaEmail(Persona persona);
   
   public void registrarPersona(Persona persona);
   
   public void modificarPersona(Persona persona);
   
   public void elimiarPersona(Persona persona);
    
}
