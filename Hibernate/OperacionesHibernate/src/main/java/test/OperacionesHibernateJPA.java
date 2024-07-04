package test;

import gt.com.dao.PersonaDAO;
import gt.com.domain.Persona;

public class OperacionesHibernateJPA {

     public static void main(String[] args) {
          PersonaDAO personaDAO = new PersonaDAO();

          personaDAO.listar();

          Persona insertarPersona = new Persona();
          insertarPersona.setNombre("Carlos");
          insertarPersona.setApellido("Perez");
          insertarPersona.setEmail("perez@ejemplo.com");
          insertarPersona.setTelefono("1234556");
          //personaDAO.insertar(insertarPersona);

          Persona updatePersona = new Persona();
          updatePersona.setIdPersona(15);
          updatePersona = personaDAO.buscarPersonaPorId(updatePersona);
          updatePersona.setNombre("Luis");
          personaDAO.modificar(updatePersona);
          
          Persona eliminarPersona = new Persona();
          eliminarPersona.setIdPersona(15);
          eliminarPersona = personaDAO.buscarPersonaPorId(eliminarPersona);
          personaDAO.eliminar(eliminarPersona);
          
          personaDAO.listar();

     }
}
