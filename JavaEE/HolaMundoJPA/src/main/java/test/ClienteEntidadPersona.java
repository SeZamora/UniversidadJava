package test;

import gt.com.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;


public class ClienteEntidadPersona {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        tx.begin();
        //el id es auto incrementar no se debe poner
        Persona persona1 = new Persona("Pedro", "Zamora", "pedroz@gmail.com", "9087-4532");
        log.debug("Objeto a persistir: "+persona1);
        //Persistir el objeto
        em.persist(persona1);
        //terminar la transaccion para que se guarde en la db
        tx.commit();
        log.debug("Objeto persistido: "+persona1);
        em.close();
        
    }
    
}
