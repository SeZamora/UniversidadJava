package gt.com.contactos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contacto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idContacto;

    private String nombre;

    private String celular;

    private String email;

}
