package gt.com.spring.dao;

import gt.com.spring.domain.Contacto;
import org.springframework.data.repository.CrudRepository;

//@Repository asi era antes
public interface ContactoDao extends CrudRepository<Contacto, Long> {


}
