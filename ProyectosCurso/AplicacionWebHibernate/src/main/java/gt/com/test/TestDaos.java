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
import gt.com.domain.Alumno;
import gt.com.domain.Contacto;
import gt.com.domain.Domicilio;
import java.util.List;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class TestDaos {
         public static void main(String[] args) {
        
        
        System.out.println("Contacto:");
        
        ContactoDao contactoDao = new ContactoDao();
        Contacto contacto = new Contacto();
        contacto.setEmail("pedro2@gmail.com");
        contacto.setTelefono("12349854");
        
        
        contactoDao.insertar(contacto);
        
 
         
        imprimir(contactoDao.listar());
        
       
        
    }
    
    private static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println("valor = " + o);
        }
    }
}
