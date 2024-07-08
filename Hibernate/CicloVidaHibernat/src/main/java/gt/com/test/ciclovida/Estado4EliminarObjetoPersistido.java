package gt.com.test.ciclovida;

import gt.com.domain.Contacto;
import javax.persistence.*;


class Estado4EliminarObjetoPersistido {
          public static void main(String[] args) {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
          EntityManager em = emf.createEntityManager();
          
         // Definimos la variable que va a recibir el objeto
          Contacto contacto = null;
          
          //Recuperamos el objeto
          //1. Estado transitivo
          contacto = em.find(Contacto.class,3);
          
          
          em.getTransaction().begin();
          
          //2. Eliminamos el objeto
          em.remove(em.merge(contacto));
          
          em.getTransaction().commit();
          
          
          //3. Estado de transitivo porque ya no esta en la DB
          System.out.println("Contacto: "+ contacto);
          
          
          
     }
}
