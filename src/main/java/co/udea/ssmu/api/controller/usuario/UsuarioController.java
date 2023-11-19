package co.udea.ssmu.api.controller.usuario;

import co.udea.ssmu.api.model.jpa.dto.servicio.ServicioDTO;
import co.udea.ssmu.api.services.usuario.facade.UsuarioFacade;
import co.udea.ssmu.api.utils.common.Messages;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuarios", description = "Gestión de detalles específicos relacionados con usuarios")
@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioFacade usuarioFacade;
    private final Messages messages;

    public UsuarioController(UsuarioFacade usuarioFacade, Messages messages){
        this.usuarioFacade = usuarioFacade;
        this.messages = messages;
    }

    @GetMapping("/historial/{id}")
    @Operation(summary = "Permite obtener el historial de servicios de un usuario por medio de su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Historial de servicios del usuario hallado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta") })
    public List<ServicioDTO> getHistoialServicios(@PathVariable Integer id){
        return usuarioFacade.getHistorialServiciosByUsuarioId(id);
    }
}
