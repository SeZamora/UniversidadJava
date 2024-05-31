package gt.com.jdbc;

import gt.com.jdbc.datos.PersonaDAO;
import gt.com.jdbc.domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();

        //insertar objeto
//        Persona personaNueva = new Persona("Jorge", " Mesa", "mesa@gmail.com","12765432");
//        personaDAO.insertar(personaNueva);

        //update
//        Persona personaUpdate = new Persona(2, "Teodora", "Martinez", "nuevo@gmail.com", "98765432");
//        personaDAO.actualizar(personaUpdate);

//        //eliminar
//        Persona personaDelete = new Persona(1);
//        personaDAO.eliminar(personaDelete);

        // listar datos
        List<Persona> personas =  personaDAO.seleccionar();
        personas.forEach(elemento ->{
            System.out.println(elemento);
        });

    }
}
