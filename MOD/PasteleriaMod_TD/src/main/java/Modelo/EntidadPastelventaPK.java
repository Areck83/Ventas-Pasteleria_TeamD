package Modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class EntidadPastelventaPK implements Serializable {
    @Column(name = "Pastel_IDPastel", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pastelIdPastel;
    @Column(name = "Venta_IDVenta", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ventaIdVenta;

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

        EntidadPastelventaPK that = (EntidadPastelventaPK) o;

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
}
