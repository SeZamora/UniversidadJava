package test;

import gt.com.dao.PersonaDAO;
import gt.com.domain.Persona;
import java.util.List;

public class TestListar {
     
     public static void main(String[] args) {
          PersonaDAO personaDao = new PersonaDAO();
          personaDao.listar();
     }
}
