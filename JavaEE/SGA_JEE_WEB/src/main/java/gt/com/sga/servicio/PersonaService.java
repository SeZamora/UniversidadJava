package gt.com.sga.servicio;

import domain.Persona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PersonaService {

    public List<Persona> listarPersonas();

    public Persona encontrarPersonaId(Persona persona);

    public Persona encontrarPersonaEmail(Persona persona);

    public void registrarPersona(Persona persona);

    public void modificarPersona(Persona persona);

    public void elimiarPersona(Persona persona);
}
