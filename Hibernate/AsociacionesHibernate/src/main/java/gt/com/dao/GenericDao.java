package gt.com.dao;

import javax.persistence.*;


public abstract class GenericDao {
     
     private static EntityManagerFactory emf;
     protected static  EntityManager em;
     private static final String PU = "HibernateJpaPU";
     
     public GenericDao(){
          if(emf == null){
               emf = Persistence.createEntityManagerFactory(PU);
          }
     }
     
     protected EntityManager getEntityManager(){
          if(em == null){
               em = emf.createEntityManager();
          }
          return em;
     }
     
}
