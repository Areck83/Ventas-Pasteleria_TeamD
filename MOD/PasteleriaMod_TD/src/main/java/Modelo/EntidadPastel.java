package Modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pastel", schema = "bdpasteleriav4")
public class EntidadPastel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPastel", nullable = false)
    private int idPastel;
    @Basic
    @Column(name = "Color", nullable = false, length = 25)
    private String color;
    @Basic
    @Column(name = "Forma", nullable = false, length = 25)
    private String forma;
    @Basic
    @Column(name = "Size", nullable = false, length = 15)
    private String size;
    @Basic
    @Column(name = "Relleno", nullable = false, length = 25)
    private String relleno;
    @Basic
    @Column(name = "TipoPan", nullable = false, length = 25)
    private String tipoPan;
    @Basic
    @Column(name = "NumPisos", nullable = false)
    private int numPisos;
    @Basic
    @Column(name = "Precio", nullable = false, precision = 0)
    private int precio;
    @Basic
    @Column(name = "Descripccion", nullable = true, length = 100)
    private String descripccion;
    @Basic
    @Column(name = "EstadoPastel", nullable = false, length = 15)
    private String estadoPastel;
    @OneToMany(mappedBy = "Pastel")
    private List<EntidadPastelventa> VentasRealizadas;

    public int getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(int idPastel) {
        this.idPastel = idPastel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getTipoPan() {
        return tipoPan;
    }

    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public String getEstadoPastel() {
        return estadoPastel;
    }

    public void setEstadoPastel(String estadoPastel) {
        this.estadoPastel = estadoPastel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntidadPastel that = (EntidadPastel) o;

        if (idPastel != that.idPastel) return false;
        if (numPisos != that.numPisos) return false;
        if (precio != that.precio) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (forma != null ? !forma.equals(that.forma) : that.forma != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (relleno != null ? !relleno.equals(that.relleno) : that.relleno != null) return false;
        if (tipoPan != null ? !tipoPan.equals(that.tipoPan) : that.tipoPan != null) return false;
        if (descripccion != null ? !descripccion.equals(that.descripccion) : that.descripccion != null) return false;
        if (estadoPastel != null ? !estadoPastel.equals(that.estadoPastel) : that.estadoPastel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPastel;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (forma != null ? forma.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (relleno != null ? relleno.hashCode() : 0);
        result = 31 * result + (tipoPan != null ? tipoPan.hashCode() : 0);
        result = 31 * result + numPisos;
        result = 31 * result + precio;
        result = 31 * result + (descripccion != null ? descripccion.hashCode() : 0);
        result = 31 * result + (estadoPastel != null ? estadoPastel.hashCode() : 0);
        return result;
    }

    public List<EntidadPastelventa> getVentasRealizadas() {
        return VentasRealizadas;
    }

    public void setVentasRealizadas(List<EntidadPastelventa> ventasRealizadas) {
        VentasRealizadas = ventasRealizadas;
    }
}
