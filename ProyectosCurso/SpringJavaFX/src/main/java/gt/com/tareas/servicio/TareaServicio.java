package gt.com.tareas.servicio;

import gt.com.tareas.modelo.Tarea;
import gt.com.tareas.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio implements ITareaServicio{

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Override
    public List<Tarea> listarTareas() {
       return tareaRepositorio.findAll();
    }

    @Override
    public Tarea buscarTareaId(Integer idTarea) {
        return tareaRepositorio.findById(idTarea).orElse(null);
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        tareaRepositorio.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        tareaRepositorio.delete(tarea);
    }
}
