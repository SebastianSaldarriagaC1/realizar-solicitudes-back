package co.udea.ssmu.api.model.jpa.model.jpa.servicio;

import co.udea.ssmu.api.model.jpa.model.jpa.conductor.Conductor;
import co.udea.ssmu.api.model.jpa.model.jpa.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conductor")
    private Conductor conductor;

    @Column(name = "id_ubicacion_origen")       //Cambiar cuando tenga la tabla Ubicación
    private Integer idUbicacionOrigen;

    @Column(name = "id_ubicacion_destino")      //Cambiar cuando tenga la tabla Ubicación
    private Integer idUbicacionDestino;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "id_tipo_servicio")      // Cambiar cuando tenga la tabla TipoServicio
    private Integer idTipoServicio;

    @Column(name = "estado")
    private String estado;

    @Column(name = "detalles")
    private String detalles;

    @Column(name = "id_categoria")      // Cambiar cuando tenga la tabla Categoria
    private Integer idCategoria;

    @Column(name = "estado_pago")
    private String estadoPago;

    @Column(name = "calificacion_conductor")
    private String calificacionConductor;

    @Column(name = "calificacion_usuario")
    private String calificacionUsuario;

    @Column(name = "id_estrategia")     // Cambiar cuando tenga la tabla Estrategia
    private Integer idEstrategia;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "costo")
    private Double costo;
}
