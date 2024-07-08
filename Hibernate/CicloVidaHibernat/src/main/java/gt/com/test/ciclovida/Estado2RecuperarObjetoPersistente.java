package gt.com.test.ciclovida;

import gt.com.domain.Contacto;
import javax.persistence.*;

public class Estado2RecuperarObjetoPersistente {
     public static void main(String[] args) {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
          EntityManager em = emf.createEntityManager();
          
          // 1. Definimos la variable que va a recibir el objeto
          Contacto contacto = new Contacto();
          
          //2.Recuperamos el objeto
          contacto = em.find(Contacto.class,3);
          
          //3. Estado de ditach(separado)
          System.out.println("Contacto: "+ contacto);
          
          
          
     }
}
