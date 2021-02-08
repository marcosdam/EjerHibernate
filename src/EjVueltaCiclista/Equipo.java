package EjVueltaCiclista;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre patrocinador)
    @Id
    @Column(name = "id_equipo")
    private int id_equipo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "patrocinador")
    private String patrocinador;


    // 1 equipo tiene muchos ciclistas y 1 ciclistas tiene 1 equipo
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEquipo")     // Clave ajena
    @OrderColumn(name = "idx")  // Índice
    private List<Ciclista> ciclistas;
    public List<Ciclista> getCiclistas() {
        return ciclistas;
    }
    public void setCiclistas(List<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public Equipo() {
    }

    public Equipo(int id_equipo, String nombre, String patrocinador) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.patrocinador = patrocinador;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }
}
