package co.udea.ssmu.api.services.usuario.facade;

import co.udea.ssmu.api.model.jpa.dto.servicio.ServicioDTO;
import co.udea.ssmu.api.model.jpa.mapper.servicio.ServicioMapper;
import co.udea.ssmu.api.model.jpa.mapper.usuario.UsuarioMapper;
import co.udea.ssmu.api.services.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioFacade {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final ServicioMapper servicioMapper;

    public UsuarioFacade(UsuarioService usuarioService, UsuarioMapper usuarioMapper, ServicioMapper servicioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
        this.servicioMapper = servicioMapper;
    }

    public List<ServicioDTO> getHistorialServiciosByUsuarioId(Integer id){
        return servicioMapper.toDto(usuarioService.getHistorialServiciosByUsuarioId(id));
    }
}
