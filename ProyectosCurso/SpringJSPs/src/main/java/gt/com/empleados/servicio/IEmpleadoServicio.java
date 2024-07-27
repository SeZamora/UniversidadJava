package gt.com.empleados.servicio;

import gt.com.empleados.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio{
    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoId(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
