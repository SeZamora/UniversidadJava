package gt.com.sga.servicio;

import gt.com.sga.domain.Persona;
import gt.com.sga.datos.PersonaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {
    
    @Inject
    private PersonaDAO personaDao;
    
    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPerson();
    }

    @Override
    public Persona encontrarPersonaId(Persona persona) {
        return personaDao.findPersonaId(persona);
    }

    @Override
    public Persona encontrarPersonaEmail(Persona persona) {
         return personaDao.findPersonaEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
      personaDao.updatePersona(persona);
    }   

    @Override
    public void elimiarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
}
