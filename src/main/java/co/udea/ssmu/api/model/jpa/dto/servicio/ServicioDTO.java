package co.udea.ssmu.api.model.jpa.dto.servicio;

import co.udea.ssmu.api.model.jpa.dto.conductor.ConductorDTO;
import co.udea.ssmu.api.model.jpa.dto.ubicacion.UbicacionDTO;
import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.model.conductor.Conductor;
import co.udea.ssmu.api.model.jpa.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ServicioDTO {
    private Integer idServicio;
    private UsuarioDTO usuario;
    private ConductorDTO conductor;
    private UbicacionDTO ubicacionOrigen;
    private UbicacionDTO ubicacionDestino;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Integer idTipoServicio;
    private String estado;
    private String detalles;
    private Integer idCategoria;
    private String estadoPago;
    private String calificacionConductor;
    private String calificacionUsuario;
    private Integer idEstrategia;
    private String motivo;
    private Double costo;

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public ConductorDTO getConductor() {
        return conductor;
    }

    public void setConductor(ConductorDTO conductor) {
        this.conductor = conductor;
    }

    public UbicacionDTO getUbicacionOrigen() {
        return ubicacionOrigen;
    }

    public void setUbicacionOrigen(UbicacionDTO ubicacionOrigen) {
        this.ubicacionOrigen = ubicacionOrigen;
    }

    public UbicacionDTO getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(UbicacionDTO ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getCalificacionConductor() {
        return calificacionConductor;
    }

    public void setCalificacionConductor(String calificacionConductor) {
        this.calificacionConductor = calificacionConductor;
    }

    public String getCalificacionUsuario() {
        return calificacionUsuario;
    }

    public void setCalificacionUsuario(String calificacionUsuario) {
        this.calificacionUsuario = calificacionUsuario;
    }

    public Integer getIdEstrategia() {
        return idEstrategia;
    }

    public void setIdEstrategia(Integer idEstrategia) {
        this.idEstrategia = idEstrategia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
