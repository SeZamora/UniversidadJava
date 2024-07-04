package gt.com.dao;

import gt.com.domain.Persona;
import jakarta.persistence.*;
import java.util.List;

public class PersonaDAO {

     private EntityManagerFactory emf;
     private EntityManager em;

     public PersonaDAO() {
          emf = Persistence.createEntityManagerFactory("HibernatePU");
          em = emf.createEntityManager();
     }

     public void listar() {
          String hql = "SELECT p from Persona p";
          Query query = em.createQuery(hql);
          List<Persona> personas = query.getResultList();
          for (Persona p : personas) {
               System.out.println("Persona:=" + p);
          }
     }

     public void insertar(Persona persona) {
          try {
               em.getTransaction().begin();
               em.persist(persona);
               em.getTransaction().commit();
          } catch (Exception e) {
               e.printStackTrace(System.out);
               em.getTransaction().rollback();
          } finally {
               if (em != null) {
                    em.close();
               }
          }

     }

     public void modificar(Persona persona) {
          try {
               em.getTransaction().begin();
               em.merge(persona);
               em.getTransaction().commit();
          } catch (Exception e) {
               e.printStackTrace(System.out);
               em.getTransaction().rollback();
          }

     }

     public void eliminar(Persona persona) {
          try {
               em.getTransaction().begin();
               em.remove(em.merge(persona));
               em.getTransaction().commit();
          } catch (Exception e) {
               e.printStackTrace(System.out);
               em.getTransaction().rollback();
          }
     }

     public Persona buscarPersonaPorId(Persona persona) {
          return em.find(Persona.class, persona.getIdPersona());
     }
}
