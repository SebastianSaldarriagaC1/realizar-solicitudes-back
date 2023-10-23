package co.udea.ssmu.api.model.jpa.model.ubicacion;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Integer idUbicacion;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "direccion")
    private String direccion;
}
