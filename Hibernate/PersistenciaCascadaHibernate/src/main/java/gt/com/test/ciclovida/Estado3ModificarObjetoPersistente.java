package gt.com.test.ciclovida;

import gt.com.domain.Contacto;
import javax.persistence.*;

public class Estado3ModificarObjetoPersistente {
     public static void main(String[] args) {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
          EntityManager em = emf.createEntityManager();
          
         // Definimos la variable que va a recibir el objeto
          Contacto contacto = null;
          
          //Recuperamos el objeto
          //1. Estado transitivo
          contacto = em.find(Contacto.class,3);
          
          //Moficamos el objeto
          contacto.setEmail("cambiar@Email.com");
          
          em.getTransaction().begin();
          
          //2. Estado persistente
          em.merge(contacto);
          
          em.getTransaction().commit();
          
          
          //3. Estado de ditach(separado)
          System.out.println("Contacto: "+ contacto);
          
          
          
     }
}
