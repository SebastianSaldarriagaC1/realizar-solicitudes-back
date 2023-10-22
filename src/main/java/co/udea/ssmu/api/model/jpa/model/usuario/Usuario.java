package co.udea.ssmu.api.model.jpa.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
