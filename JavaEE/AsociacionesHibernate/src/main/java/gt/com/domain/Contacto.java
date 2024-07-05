package gt.com.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Contacto implements Serializable{
     private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_contacto")
     private Integer idContacto;
     
     private String telefono;
     
     private String email;
     
     public Contacto(){}

     public Contacto(Integer idContacto) {
          this.idContacto = idContacto;
     }

     public static long getSerialVersionUID() {
          return serialVersionUID;
     }

     public Integer getIdContacto() {
          return idContacto;
     }

     public String getTelefono() {
          return telefono;
     }

     public String getEmail() {
          return email;
     }

     @Override
     public String toString() {
          return "Contacto{" + "idContacto=" + idContacto + ", telefono=" + telefono + ", email=" + email + '}';
     }

     @Override
     public int hashCode() {
          int hash = 3;
          hash = 89 * hash + Objects.hashCode(this.idContacto);
          return hash;
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj) {
               return true;
          }
          if (obj == null) {
               return false;
          }
          if (getClass() != obj.getClass()) {
               return false;
          }
          final Contacto other = (Contacto) obj;
          return Objects.equals(this.idContacto, other.idContacto);
     }
     
     
     
}
