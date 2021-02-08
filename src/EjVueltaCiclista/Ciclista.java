package EjVueltaCiclista;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// Mapeado JPA (@Entity representada en @Table (nombre ciclista) -> ANTES DE DECLARAR LA CLASE
@Entity
@Table(name = "ciclista")
public class Ciclista implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre apellidos) etc
    @Id
    @Column(name = "dorsal")
    private int dorsal;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;



    // 1 ciclista tendrá 1 palmares y 1 palmares tendrá 1 ciclista  1:1
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Palmares palmares;
    public Palmares getPalmares() {
        return palmares;
    }
    public void setPalmares(Palmares palmares) {
        this.palmares = palmares;
    }

    // 1 ciclista tendrá 1 equipo y 1 equipo muchos ciclistas
    @ManyToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Ciclista() {
    }

    public Ciclista(int dorsal, String nombre, String apellidos) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return " Dorsal: " + dorsal +
                " Nombre: " + nombre + '\'' +
                " Apellidos: " + apellidos;
    }
}
