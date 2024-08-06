package gt.rh.servicio;

import gt.rh.modelo.Empleado;

import java.util.List;

public interface IServicioEmpleado {
    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoId(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
