package gt.com.sga.cliente.ciclovidajpa;

import gt.com.sga.domain.Persona;
import javax.persistence.*; 
import org.apache.logging.log4j.*;

public class ModificarObjetoSesioLargaJPA {
        static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso. ejecutamos SQL de tipo select
        Persona persona1 = em.find(Persona.class, 1);
        
        log.debug("Objecto encontrado:" + persona1);
        
        //Paso 3. setValue(nuevoValor)
        persona1.setEmail("modif.jaurez@mail.com");

        
        //Paso 4. Termina la transaccion 1
        tx.commit();
        
        //Objeto en estado detached
        log.debug("objeto modificado:" + persona1);

        //Cerramos el entity manager
        em.close();

    }
}
