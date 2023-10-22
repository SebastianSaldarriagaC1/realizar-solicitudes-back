package co.udea.ssmu.api.services.servicio.facade;

import co.udea.ssmu.api.model.jpa.dto.servicio.ServicioDTO;
import co.udea.ssmu.api.model.jpa.mapper.servicio.ServicioMapper;
import co.udea.ssmu.api.services.servicio.service.ServicioService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioFacade {

    private final ServicioService servicioService;
    private final ServicioMapper servicioMapper;

    public ServicioFacade(ServicioService servicioService, ServicioMapper servicioMapper){
        this.servicioService = servicioService;
        this.servicioMapper = servicioMapper;
    }

    public ServicioDTO solicitar(ServicioDTO servicioDTO){
        return servicioMapper.toDto(servicioService.solicitar(servicioMapper.toEntity(servicioDTO)));
    }

    public ServicioDTO aceptar(ServicioDTO servicioDTO){
        return servicioMapper.toDto(servicioService.aceptar(servicioMapper.toEntity(servicioDTO)));
    }

    public void rechazar(Integer id){
        servicioService.rechazar(id);
    }
}
