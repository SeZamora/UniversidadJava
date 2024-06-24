package gt.com.sga.cliente.ciclovidajpa;

import gt.com.sga.domain.Persona;
import javax.persistence.*; 
import org.apache.logging.log4j.*;

public class EncontrarObjetoJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 4);
        
        //Paso 3. termina la transaccion
        tx.commit();
       
        //Objeto en estado de detached
        log.debug("Objeto recuperado:" + persona1);
        
        //Cerramos el entity manager
        em.close();

    }
}
