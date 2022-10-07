package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "pastelventa", schema = "bdpasteleriav4", catalog = "")
@IdClass(EntidadPastelventaPK.class)
public class EntidadPastelventa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Pastel_IDPastel", nullable = false)
    private int pastelIdPastel;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Venta_IDVenta", nullable = false)
    private int ventaIdVenta;
    @ManyToOne
    @JoinColumn(name = "Venta_IDVenta", referencedColumnName = "IDVenta", nullable = false)
    private EntidadVenta Venta;
    @ManyToOne
    @JoinColumn(name = "Pastel_IDPastel", referencedColumnName = "IDPastel", nullable = false)
    private EntidadPastel Pastel;

    public int getPastelIdPastel() {
        return pastelIdPastel;
    }

    public void setPastelIdPastel(int pastelIdPastel) {
        this.pastelIdPastel = pastelIdPastel;
    }

    public int getVentaIdVenta() {
        return ventaIdVenta;
    }

    public void setVentaIdVenta(int ventaIdVenta) {
        this.ventaIdVenta = ventaIdVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntidadPastelventa that = (EntidadPastelventa) o;

        if (pastelIdPastel != that.pastelIdPastel) return false;
        if (ventaIdVenta != that.ventaIdVenta) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pastelIdPastel;
        result = 31 * result + ventaIdVenta;
        return result;
    }

    public EntidadVenta getVenta() {
        return Venta;
    }

    public void setVenta(EntidadVenta venta) {
        Venta = venta;
    }

    public EntidadPastel getPastel() {
        return Pastel;
    }

    public void setPastel(EntidadPastel pastel) {
        Pastel = pastel;
    }
}
