package gt.com.invetario.repositorio;

import gt.com.invetario.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProducto extends JpaRepository<Producto, Integer> {
}
