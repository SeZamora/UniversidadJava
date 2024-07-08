package gt.com.test.ciclovida;

import gt.com.domain.Contacto;
import javax.persistence.*;

public class Estado1Persistido {
     public static void main(String[] args) {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
          EntityManager em = emf.createEntityManager();
          
          //1. estado Transitivo
          Contacto contacto = new Contacto();
          contacto.setEmail("contacto1@gmail.com");
          contacto.setTelefono("12435678");
          
          //2. Estado Persistente al objeto
          em.getTransaction().begin();
          em.persist(contacto);
          em.getTransaction().commit();
          
          //3. Estado Detach (separado)
          System.out.println("contacto: "+contacto);
          
          
          
     }
}
