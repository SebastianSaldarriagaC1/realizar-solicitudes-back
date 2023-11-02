package co.udea.ssmu.api.model.jpa.dto.usuario;

public class UsuarioDTO {
    private Integer idUsuario;
    private Integer idGrupo;
    private String nombre;
    private String celular;
    private String email;
    private String cedula;
    private String rol;
    private Integer idTipoUsuario;
    private Integer nroServicios;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer idUsuario, Integer idGrupo, String nombre, String celular, String email, String cedula, String rol, Integer idTipoUsuario, Integer nroServicios) {
        this.idUsuario = idUsuario;
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.celular = celular;
        this.email = email;
        this.cedula = cedula;
        this.rol = rol;
        this.idTipoUsuario = idTipoUsuario;
        this.nroServicios = nroServicios;
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
}
