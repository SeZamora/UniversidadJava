package gt.com.dao;

import gt.com.domain.Asignacion;
import java.util.List;
import javax.persistence.*;

public class AsignacionDao extends GenericDao {

     public List<Asignacion> listar() {
          String consulta = "SELECT a FROM Asignacion a";
          em = getEntityManager();
          Query query = em.createQuery(consulta);
          return query.getResultList();
     }

     public void insertar(Asignacion asignacion) {
          try {
               em = getEntityManager();
               em.getTransaction().begin();
               em.persist(asignacion);
               em.getTransaction().commit();
          } catch (Exception ex) {
               ex.printStackTrace(System.out);
          } finally {
               if (em != null) {
                    em.close();
               }
          }
     }

     public void actualizar(Asignacion asignacion) {
          try {
               em = getEntityManager();
               em.getTransaction().begin();
               em.merge(asignacion);
               em.getTransaction().commit();
          } catch (Exception ex) {
               ex.printStackTrace(System.out);
          } finally {
               if (em != null) {
                    em.close();
               }
          }
     }

     public void eliminar(Asignacion asignacion) {
          try {
               em = getEntityManager();
               em.getTransaction().begin();
               em.remove(em.merge(asignacion));
               em.getTransaction().commit();
          } catch (Exception ex) {
               ex.printStackTrace(System.out);
          } finally {
               if (em != null) {
                    em.close();
               }
          }
     }

     public Object buscarPorId(Asignacion asignacion) {
          em = getEntityManager();
          return em.find(Asignacion.class, asignacion.getIdAsignacion());
     }
}
