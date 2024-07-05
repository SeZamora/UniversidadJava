package gt.com.servicio;

import gt.com.dao.PersonaDAO;
import gt.com.domain.Persona;
import java.util.List;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class ServicioPersonas {
     
     PersonaDAO personaDao;
     
     public ServicioPersonas(){
          this.personaDao = new PersonaDAO();
     }
     
     public List<Persona> listarPersonas(){
          return personaDao.listar();
     }
}
