package gt.com.spring.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import jakarta.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name="persona")
public class Persona implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona")
    private Long idPersona;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    private String telefono;

    @NotEmpty
    private String email;


}
