package gt.rh.controlador;

import gt.rh.modelo.Empleado;
import gt.rh.servicio.IServicioEmpleado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
}
