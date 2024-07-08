/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.test;

import gt.com.dao.AlumnoDao;
import gt.com.dao.AsignacionDao;
import gt.com.dao.ContactoDao;
import gt.com.dao.CursoDao;
import gt.com.dao.DomicilioDao;
import java.util.List;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class TestDaos {
         public static void main(String[] args) {
        AlumnoDao alumnoDao = new AlumnoDao();
        System.out.println("Alumnos:");
        imprimir(alumnoDao.listar());
        
        System.out.println("Domicilios:");
        DomicilioDao domicilioDao = new DomicilioDao();
        imprimir(domicilioDao.listar());
        
        System.out.println("Contacto:");
        ContactoDao contactoDao = new ContactoDao();
        imprimir(contactoDao.listar());
        
        System.out.println("Cursos:");
        CursoDao cursoDao = new CursoDao();
        imprimir(cursoDao.listar());
        
        System.out.println("Asignaciones:");
        AsignacionDao asignacionDao = new AsignacionDao();
        imprimir(asignacionDao.listar());
    }
    
    private static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println("valor = " + o);
        }
    }
}
