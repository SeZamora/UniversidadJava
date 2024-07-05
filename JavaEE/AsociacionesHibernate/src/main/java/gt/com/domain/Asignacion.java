package gt.com.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

public class Asignacion implements Serializable {
      private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_asignacion")
     private Integer idAsignacion;
     
     private String turno;
     
     @JoinColumn(name  = "id_curso", referencedColumnName = "id_curso")
     @ManyToOne
     private Curso curso;
     
     @JoinColumn(name  = "id_alumno", referencedColumnName = "id_alumno")
     @ManyToOne
     private Alumno alumno;

     public Asignacion() {
     }

     public Asignacion(Integer idAsignacion) {
          this.idAsignacion = idAsignacion;
     }

     public Integer getIdAsignacion() {
          return idAsignacion;
     }

     public void setIdAsignacion(Integer idAsignacion) {
          this.idAsignacion = idAsignacion;
     }

     public String getTurno() {
          return turno;
     }

     public void setTurno(String turno) {
          this.turno = turno;
     }

     public Curso getCurso() {
          return curso;
     }

     public void setCurso(Curso curso) {
          this.curso = curso;
     }

     public Alumno getAlumno() {
          return alumno;
     }

     public void setAlumno(Alumno alumno) {
          this.alumno = alumno;
     }

     @Override
     public String toString() {
          return "Asignacion{" + "idAsignacion=" + idAsignacion + ", turno=" + turno + ", curso=" + curso + ", alumno=" + alumno + '}';
     }

     @Override
     public int hashCode() {
          int hash = 7;
          hash = 89 * hash + Objects.hashCode(this.idAsignacion);
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
          final Asignacion other = (Asignacion) obj;
          return Objects.equals(this.idAsignacion, other.idAsignacion);
     }
     
     
}
