package Modelo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "venta", schema = "bdpasteleriav4", catalog = "")
public class EntidadVenta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVenta", nullable = false)
    private int idVenta;
    @Basic
    @Column(name = "Tipo", nullable = false, length = 25)
    private String tipo;
    @Basic
    @Column(name = "HoraEntrega", nullable = false)
    private Time horaEntrega;
    @Basic
    @Column(name = "FechaEntrega", nullable = false)
    private Date fechaEntrega;
    @Basic
    @Column(name = "HoraVenta", nullable = false)
    private Time horaVenta;
    @Basic
    @Column(name = "FechaVenta", nullable = false)
    private Date fechaVenta;
    @Basic
    @Column(name = "Anticipo", nullable = false, precision = 0)
    private int anticipo;
    @Basic
    @Column(name = "Total", nullable = false, precision = 0)
    private int total;
    @Basic
    @Column(name = "Entregado", nullable = false, length = 5)
    private String entregado;
    @Basic
    @Column(name = "Trabajador_IDTrabajador", nullable = false)
    private int trabajadorIdTrabajador;
    @Basic
    @Column(name = "Cliente_IDCliente", nullable = false)
    private int clienteIdCliente;
    @ManyToOne
    @JoinColumn(name = "Trabajador_IDTrabajador", referencedColumnName = "IDTrabajador", nullable = false)
    private EntidadTrabajador Trabajador;
    @ManyToOne
    @JoinColumn(name = "Cliente_IDCliente", referencedColumnName = "IDCliente", nullable = false)
    private EntidadCliente Cliente;
    @OneToMany(mappedBy = "Venta")
    private List<EntidadPastelventa> PastelesVendidos;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Time horaVenta) {
        this.horaVenta = horaVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(int anticipo) {
        this.anticipo = anticipo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public int getTrabajadorIdTrabajador() {
        return trabajadorIdTrabajador;
    }

    public void setTrabajadorIdTrabajador(int trabajadorIdTrabajador) {
        this.trabajadorIdTrabajador = trabajadorIdTrabajador;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntidadVenta that = (EntidadVenta) o;

        if (idVenta != that.idVenta) return false;
        if (anticipo != that.anticipo) return false;
        if (total != that.total) return false;
        if (trabajadorIdTrabajador != that.trabajadorIdTrabajador) return false;
        if (clienteIdCliente != that.clienteIdCliente) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (horaEntrega != null ? !horaEntrega.equals(that.horaEntrega) : that.horaEntrega != null) return false;
        if (fechaEntrega != null ? !fechaEntrega.equals(that.fechaEntrega) : that.fechaEntrega != null) return false;
        if (horaVenta != null ? !horaVenta.equals(that.horaVenta) : that.horaVenta != null) return false;
        if (fechaVenta != null ? !fechaVenta.equals(that.fechaVenta) : that.fechaVenta != null) return false;
        if (entregado != null ? !entregado.equals(that.entregado) : that.entregado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVenta;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (horaEntrega != null ? horaEntrega.hashCode() : 0);
        result = 31 * result + (fechaEntrega != null ? fechaEntrega.hashCode() : 0);
        result = 31 * result + (horaVenta != null ? horaVenta.hashCode() : 0);
        result = 31 * result + (fechaVenta != null ? fechaVenta.hashCode() : 0);
        result = 31 * result + anticipo;
        result = 31 * result + total;
        result = 31 * result + (entregado != null ? entregado.hashCode() : 0);
        result = 31 * result + trabajadorIdTrabajador;
        result = 31 * result + clienteIdCliente;
        return result;
    }

    public EntidadTrabajador getTrabajador() {
        return Trabajador;
    }

    public void setTrabajador(EntidadTrabajador trabajador) {
        Trabajador = trabajador;
    }

    public EntidadCliente getCliente() {
        return Cliente;
    }

    public void setCliente(EntidadCliente cliente) {
        Cliente = cliente;
    }

    public List<EntidadPastelventa> getPastelesVendidos() {
        return PastelesVendidos;
    }

    public void setPastelesVendidos(List<EntidadPastelventa> pastelesVendidos) {
        PastelesVendidos = pastelesVendidos;
    }
}
