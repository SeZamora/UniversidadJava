package gt.com.invetario.servicio;

import gt.com.invetario.modelo.Producto;
import gt.com.invetario.repositorio.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{
    @Autowired
    private RepositorioProducto repositorioProducto;

    @Override
    public List<Producto> listarProductos() {
        return this.repositorioProducto.findAll();
    }

    @Override
    public Producto buscarProductoId(Integer idProducto) {
        return this.repositorioProducto.findById(idProducto).orElse(null);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.repositorioProducto.save(producto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        this.repositorioProducto.deleteById(idProducto);
    }
}
