package Modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trabajador", schema = "bdpasteleriav4")
public class EntidadTrabajador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDTrabajador", nullable = false)
    private int idTrabajador;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 25)
    private String nombre;
    @Basic
    @Column(name = "PrimerApellido", nullable = false, length = 25)
    private String primerApellido;
    @Basic
    @Column(name = "SegundoApellido", nullable = true, length = 25)
    private String segundoApellido;
    @Basic
    @Column(name = "Telefono", nullable = false, length = 15)
    private String telefono;
    @Basic
    @Column(name = "Pass", nullable = false, length = 30)
    private String pass;
    @Basic
    @Column(name = "Tipo", nullable = false, length = 15)
    private String tipo;
    @OneToMany(mappedBy = "Trabajador")
    private List<EntidadVenta> Ventas;

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntidadTrabajador that = (EntidadTrabajador) o;

        if (idTrabajador != that.idTrabajador) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (primerApellido != null ? !primerApellido.equals(that.primerApellido) : that.primerApellido != null)
            return false;
        if (segundoApellido != null ? !segundoApellido.equals(that.segundoApellido) : that.segundoApellido != null)
            return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTrabajador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (primerApellido != null ? primerApellido.hashCode() : 0);
        result = 31 * result + (segundoApellido != null ? segundoApellido.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    public List<EntidadVenta> getVentas() {
        return Ventas;
    }

    public void setVentas(List<EntidadVenta> ventas) {
        Ventas = ventas;
    }
}
