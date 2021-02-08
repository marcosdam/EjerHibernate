package EjVueltaCiclista;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "palmares")
public class Palmares implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (vueltas, maillots)
    @Id
    @Column(name = "id_palmares")
    private int id_palmares;
    @Column(name = "vueltas_ganadas")
    private int vueltas_ganadas;
    @Column(name = "maillots_ganados")
    private int maillots_ganados;

    // 1 Palmares tiene 1 ciclista y 1 ciclista 1 palmares      1:1
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Ciclista ciclista;
    public Ciclista getCiclista() {
        return ciclista;
    }
    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
    }

    public Palmares() {
    }

    public Palmares(int id_palmares, int vueltas_ganadas, int maillots_ganados) {
        this.id_palmares = id_palmares;
        this.vueltas_ganadas = vueltas_ganadas;
        this.maillots_ganados = maillots_ganados;
    }

    public int getId_palmares() {
        return id_palmares;
    }

    public void setId_palmares(int id_palmares) {
        this.id_palmares = id_palmares;
    }

    public int getVueltas_ganadas() {
        return vueltas_ganadas;
    }

    public void setVueltas_ganadas(int vueltas_ganadas) {
        this.vueltas_ganadas = vueltas_ganadas;
    }

    public int getMaillots_ganados() {
        return maillots_ganados;
    }

    public void setMaillots_ganados(int maillots_ganados) {
        this.maillots_ganados = maillots_ganados;
    }
}
