package gt.com.spring.dao;

import gt.com.spring.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//@Repository asi era antes
public interface PersonaDao extends JpaRepository<Persona, Long> {


}
