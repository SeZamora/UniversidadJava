package gt.com.test.cascade;

import gt.com.domain.Alumno;
import gt.com.domain.Contacto;
import gt.com.domain.Domicilio;
import javax.persistence.*;

public class PesistenciaCascadaTest {
     public static void main(String[] args) {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
          EntityManager em = emf.createEntityManager();
                 
          Contacto contacto = new Contacto();
          contacto.setEmail("cascada@email.com");
          contacto.setTelefono("12344556");
          
          Domicilio domicilio = new Domicilio();
          domicilio.setCalle("5ta Av");
          domicilio.setNoCalle("11");
          domicilio.setPais("Guatemala");
          
         Alumno alumno = new Alumno();
         
         alumno.setNombre("Gerardo");
         alumno.setApellido("Gomez");
         alumno.setDomicilio(domicilio);
         alumno.setContacto(contacto);
         
         em.getTransaction().begin();
         em.persist(alumno);
         em.getTransaction().commit();
         
          System.out.println("Alumno: "+alumno);
          
          
     }
}
