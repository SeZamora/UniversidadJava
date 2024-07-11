package gt.com.spring.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="contacto")
public class Contacto implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contacto")
    private Long idContacto;

    private String telefono;

    private String email;


}
