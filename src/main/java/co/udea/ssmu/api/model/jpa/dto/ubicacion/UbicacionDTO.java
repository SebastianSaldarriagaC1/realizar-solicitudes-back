package co.udea.ssmu.api.model.jpa.dto.ubicacion;

public class UbicacionDTO {
    private Integer idUbicacion;
    private Double latitud;
    private Double longitud;
    private String direccion;

    public UbicacionDTO() {
    }

    public UbicacionDTO(Integer idUbicacion, Double latitud, Double longitud, String direccion) {
        this.idUbicacion = idUbicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
