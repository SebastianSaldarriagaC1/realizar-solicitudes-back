package co.udea.ssmu.api.controller.conductor;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Conductores", description = "Gestión de detalles específicos relacionados con conductores")
@RestController
@CrossOrigin("*")
@RequestMapping("/api/conductor")
public class ConductorController {
}
