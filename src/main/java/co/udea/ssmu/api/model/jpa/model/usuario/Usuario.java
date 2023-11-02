package co.udea.ssmu.api.model.jpa.model.usuario;

import co.udea.ssmu.api.model.jpa.model.servicio.Servicio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_grupo")          // Cambiar cuando tenga la tabla grupo
    private Integer idGrupo;

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

    @Column(name = "id_tipo_usuario")       // Cambiar cuando tenga la tabla TipoUsuario
    private Integer idTipoUsuario;

    @Column(name = "nro_servicios")
    private Integer nroServicios;

    //Relaciones
    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Servicio> servicios;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, Integer idGrupo, String nombre, String celular, String email, String cedula, String rol, Integer idTipoUsuario, Integer nroServicios, List<Servicio> servicios) {
        this.idUsuario = idUsuario;
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.celular = celular;
        this.email = email;
        this.cedula = cedula;
        this.rol = rol;
        this.idTipoUsuario = idTipoUsuario;
        this.nroServicios = nroServicios;
        this.servicios = servicios;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
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

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
