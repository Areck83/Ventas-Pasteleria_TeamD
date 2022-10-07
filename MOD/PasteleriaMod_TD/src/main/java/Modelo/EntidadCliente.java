package Modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente", schema = "bdpasteleriav4")
public class EntidadCliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCliente", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "NombreCliente", nullable = false, length = 25)
    private String nombreCliente;
    @Basic
    @Column(name = "PrimerApellido", nullable = false, length = 25)
    private String primerApellido;
    @Basic
    @Column(name = "SegundoApellido", nullable = false, length = 25)
    private String segundoApellido;
    @Basic
    @Column(name = "Telefono", nullable = false, length = 15)
    private String telefono;
    @Basic
    @Column(name = "TelRecuperacion", nullable = true, length = 15)
    private String telRecuperacion;
    @Basic
    @Column(name = "Direccion_IDDireccion", nullable = false)
    private int direccionIdDireccion;
    @OneToMany(mappedBy = "Cliente")
    private List<EntidadVenta> Ventas;
    @OneToOne
    @JoinColumn(name = "Direccion_IDDireccion", referencedColumnName = "IDDireccion", nullable = false)
    private EntidadDireccion Direccion;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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

    public String getTelRecuperacion() {
        return telRecuperacion;
    }

    public void setTelRecuperacion(String telRecuperacion) {
        this.telRecuperacion = telRecuperacion;
    }

    public int getDireccionIdDireccion() {
        return direccionIdDireccion;
    }

    public void setDireccionIdDireccion(int direccionIdDireccion) {
        this.direccionIdDireccion = direccionIdDireccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntidadCliente that = (EntidadCliente) o;

        if (idCliente != that.idCliente) return false;
        if (direccionIdDireccion != that.direccionIdDireccion) return false;
        if (nombreCliente != null ? !nombreCliente.equals(that.nombreCliente) : that.nombreCliente != null)
            return false;
        if (primerApellido != null ? !primerApellido.equals(that.primerApellido) : that.primerApellido != null)
            return false;
        if (segundoApellido != null ? !segundoApellido.equals(that.segundoApellido) : that.segundoApellido != null)
            return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (telRecuperacion != null ? !telRecuperacion.equals(that.telRecuperacion) : that.telRecuperacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (nombreCliente != null ? nombreCliente.hashCode() : 0);
        result = 31 * result + (primerApellido != null ? primerApellido.hashCode() : 0);
        result = 31 * result + (segundoApellido != null ? segundoApellido.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (telRecuperacion != null ? telRecuperacion.hashCode() : 0);
        result = 31 * result + direccionIdDireccion;
        return result;
    }

    public List<EntidadVenta> getVentas() {
        return Ventas;
    }

    public void setVentas(List<EntidadVenta> ventas) {
        Ventas = ventas;
    }

    public EntidadDireccion getDireccion() {
        return Direccion;
    }

    public void setDireccion(EntidadDireccion direccion) {
        Direccion = direccion;
    }
}
