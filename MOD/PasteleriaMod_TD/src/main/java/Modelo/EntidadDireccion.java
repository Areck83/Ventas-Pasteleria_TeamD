package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "direccion", schema = "bdpasteleriav4", catalog = "")
public class EntidadDireccion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDDireccion", nullable = false)
    private int idDireccion;
    @Basic
    @Column(name = "Ciudad", nullable = false, length = 25)
    private String ciudad;
    @Basic
    @Column(name = "Colonia", nullable = false, length = 25)
    private String colonia;
    @Basic
    @Column(name = "Calle", nullable = false, length = 25)
    private String calle;
    @Basic
    @Column(name = "NumInterior", nullable = true)
    private Integer numInterior;
    @Basic
    @Column(name = "NumExterior", nullable = false)
    private int numExterior;
    @Basic
    @Column(name = "Detalles", nullable = false, length = 100)
    private String detalles;
    @OneToOne(mappedBy = "Direccion")
    private EntidadCliente Cliente;

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(Integer numInterior) {
        this.numInterior = numInterior;
    }

    public int getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(int numExterior) {
        this.numExterior = numExterior;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntidadDireccion that = (EntidadDireccion) o;

        if (idDireccion != that.idDireccion) return false;
        if (numExterior != that.numExterior) return false;
        if (ciudad != null ? !ciudad.equals(that.ciudad) : that.ciudad != null) return false;
        if (colonia != null ? !colonia.equals(that.colonia) : that.colonia != null) return false;
        if (calle != null ? !calle.equals(that.calle) : that.calle != null) return false;
        if (numInterior != null ? !numInterior.equals(that.numInterior) : that.numInterior != null) return false;
        if (detalles != null ? !detalles.equals(that.detalles) : that.detalles != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDireccion;
        result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
        result = 31 * result + (colonia != null ? colonia.hashCode() : 0);
        result = 31 * result + (calle != null ? calle.hashCode() : 0);
        result = 31 * result + (numInterior != null ? numInterior.hashCode() : 0);
        result = 31 * result + numExterior;
        result = 31 * result + (detalles != null ? detalles.hashCode() : 0);
        return result;
    }

    public EntidadCliente getCliente() {
        return Cliente;
    }

    public void setCliente(EntidadCliente cliente) {
        Cliente = cliente;
    }
}
