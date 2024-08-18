package gt.rh.controlador;

import gt.rh.excepcion.RecursoNoEcontradoExcepcion;
import gt.rh.modelo.Empleado;
import gt.rh.servicio.IServicioEmpleado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
//http://localhost:8080/rh-app/xxxxx
@RequestMapping("rh-app")
@CrossOrigin("http://localhost:3000")
public class ControladorEmpleado {
    private static final Logger logger = LoggerFactory.getLogger(ControladorEmpleado.class);

    @Autowired
    private IServicioEmpleado servicioEmpleado;
    //http://localhost:8080/rh-app/empleados
    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados(){
        return servicioEmpleado.listarEmpleados();
    }

    @PostMapping("empleados")
    public void agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar: "+empleado);
        servicioEmpleado.guardarEmpleado(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> retornarEmpleado(@PathVariable Integer id){
        Empleado empleado = servicioEmpleado.buscarEmpleadoId(id);
        if (empleado == null){
            throw new RecursoNoEcontradoExcepcion("No se encontro el id: "+id);
        } else {
            return ResponseEntity.ok(empleado);
        }
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoEncontrado){
        Empleado empleado = servicioEmpleado.buscarEmpleadoId(id);
        if (empleado == null){
            throw new RecursoNoEcontradoExcepcion("No se encontro el id: "+id);
        }

        empleado.setNombre(empleadoEncontrado.getNombre());
        empleado.setDepartamento(empleadoEncontrado.getDepartamento());
        empleado.setSueldo(empleadoEncontrado.getSueldo());

        servicioEmpleado.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> elimnarEmpleado(@PathVariable Integer id){
        Empleado empleado = servicioEmpleado.buscarEmpleadoId(id);
        if (empleado == null){
            throw new RecursoNoEcontradoExcepcion("No se encontro el id: "+id);
        }
        servicioEmpleado.eliminarEmpleado(empleado);
        //Json{"elimnar": true}
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);


    }

}
