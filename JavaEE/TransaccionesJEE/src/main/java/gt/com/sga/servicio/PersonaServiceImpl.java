package gt.com.sga.servicio;

import gt.com.sga.domain.Persona;
import gt.com.sga.datos.PersonaDAO;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

     @Inject
     private PersonaDAO personaDao;

     @Resource
     private SessionContext contexto;

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
          try {
               personaDao.updatePersona(persona);
          } catch (Throwable t) {
               contexto.setRollbackOnly();
               t.printStackTrace(System.out);
          }
     }

     @Override
     public void elimiarPersona(Persona persona) {
          personaDao.deletePersona(persona);
     }

}
