package gt.com.sga.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Persona implements Serializable{
    private static final long serialVersionUID=1;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona")
    private int idPersona;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    public Persona(){
        
    }

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono= telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonol() {
        return telefono;
    }

    public void setTelefonol(String telefonol) {
        this.telefono = telefonol;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefonol=" + telefono+ '}';
    }
    
    
    
}
