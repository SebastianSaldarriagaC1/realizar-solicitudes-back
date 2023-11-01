package co.udea.ssmu.api.model.jpa.model.conductor;

import co.udea.ssmu.api.model.jpa.model.servicio.Servicio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "conductor")
public class Conductor {

    //Columnas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conductor")
    private Integer idConductor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "celular")
    private String celular;

    @Column(name = "email")
    private String email;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "rol")
    private String rol;

    @Column(name = "id_tipo_usuario")
    private Integer idTipoUsuario;

    @Column(name = "nro_servicios")
    private Integer nroServicios;

    @Column(name = "placa")
    private String placa;

    //Relaciones
    @JsonIgnore
    @OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Servicio> servicios;

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getNroServicios() {
        return nroServicios;
    }

    public void setNroServicios(Integer nroServicios) {
        this.nroServicios = nroServicios;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
