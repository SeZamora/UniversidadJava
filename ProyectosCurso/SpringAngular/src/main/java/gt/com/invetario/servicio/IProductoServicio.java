package gt.com.invetario.servicio;

import gt.com.invetario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> listarProductos();

    public Producto buscarProductoId(Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public void eliminarProducto(Integer idProducto);
}
