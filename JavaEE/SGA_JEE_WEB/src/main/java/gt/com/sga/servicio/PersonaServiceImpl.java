package gt.com.sga.servicio;

import domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jorge", "Zamora", "prueba@gmail.com", "1234565"));
        personas.add(new Persona(2, "Alcira", "Monte", "prueba2@gmail.com", "1237698"));
        personas.add(new Persona(3, "Luis", "Gomez", "prueba3@gmail.com", "98765432"));
        return personas;

    }

    @Override
    public Persona encontrarPersonaId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaEmail(Persona persona) {
         return null;
    }

    @Override
    public void registrarPersona(Persona persona) {

    }

    @Override
    public void modificarPersona(Persona persona) {

    }

    @Override
    public void elimiarPersona(Persona persona) {

    }
    
}
