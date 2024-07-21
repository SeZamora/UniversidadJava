package gt.com.spring.zona_fit.repositorio;

import gt.com.spring.zona_fit.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}
