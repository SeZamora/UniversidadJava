package gt.com.tareas.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tarea {

    @Id
    @Column(name = "id_tarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarea;

    @Column(name = "nombre_tarea")
    private String nombreTarea;

    private String responsable;

    private String status;

}
