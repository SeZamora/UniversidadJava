package gt.com.invetario.controlador;

import gt.com.invetario.excepcion.RecursoNoEncontrado;
import gt.com.invetario.modelo.Producto;
import gt.com.invetario.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//agregarle un nombre para que no este solo en el local host
//http://localhost:8080/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;


    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        return this.productoServicio.listarProductos();
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("producto: "+producto);
        return this.productoServicio.guardarProducto(producto);

    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoId(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoId(id);
        if (producto != null){
            return ResponseEntity.ok(producto);
        }else {
            throw new RecursoNoEncontrado("No se encontro el id: " + id);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido){
        Producto producto = this.productoServicio.buscarProductoId(id);
        if (producto == null){
            throw new RecursoNoEncontrado("No se encontro el id: "+id);
        }
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setExistencia(productoRecibido.getExistencia());
        producto.setPrecio(productoRecibido.getPrecio());
        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id){
        Producto producto = productoServicio.buscarProductoId(id);
        if (producto == null){
            throw new RecursoNoEncontrado("No se encontro el id: "+id);
        }
        this.productoServicio.eliminarProducto(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }



}
