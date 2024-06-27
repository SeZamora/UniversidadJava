package gt.com.sga.datos;

import gt.com.sga.domain.Persona;
import java.util.List;


public interface PersonaDAO {
    public List<Persona> findAllPerson();
    public Persona findPersonaId(Persona persona);
    public Persona findPersonaEmail(Persona persona);
    public void insertPersona(Persona persona);
    public void updatePersona(Persona persona);
    public void deletePersona(Persona persona);
    
    
}
