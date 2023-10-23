package co.udea.ssmu.api.services.servicio.facade;

import co.udea.ssmu.api.model.jpa.dto.servicio.ServicioDTO;
import co.udea.ssmu.api.model.jpa.dto.ubicacion.UbicacionDTO;
import co.udea.ssmu.api.model.jpa.mapper.servicio.ServicioMapper;
import co.udea.ssmu.api.model.jpa.mapper.ubicacion.UbicacionMapper;
import co.udea.ssmu.api.model.jpa.model.ubicacion.Ubicacion;
import co.udea.ssmu.api.services.servicio.service.ServicioService;
import co.udea.ssmu.api.services.ubicacion.service.UbicacionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioFacade {

    private final ServicioService servicioService;
    private final ServicioMapper servicioMapper;
    private final UbicacionService ubicacionService;
    private final UbicacionMapper ubicacionMapper;

    public ServicioFacade(ServicioService servicioService, ServicioMapper servicioMapper, UbicacionService ubicacionService, UbicacionMapper ubicacionMapper) {
        this.servicioService = servicioService;
        this.servicioMapper = servicioMapper;
        this.ubicacionService = ubicacionService;
        this.ubicacionMapper = ubicacionMapper;
    }

    public ServicioDTO solicitar(ServicioDTO servicioDTO) {
        Ubicacion origenEntity = ubicacionService.create(ubicacionMapper.toEntity(servicioDTO.getUbicacionOrigen()));
        Ubicacion destinoEntity = ubicacionService.create(ubicacionMapper.toEntity(servicioDTO.getUbicacionDestino()));

        servicioDTO.getUbicacionOrigen().setIdUbicacion(origenEntity.getIdUbicacion());
        servicioDTO.getUbicacionDestino().setIdUbicacion(destinoEntity.getIdUbicacion());

        // Método para calcular el precio
        servicioDTO.setCosto(20000d);

        return servicioMapper.toDto(servicioService.create(servicioMapper.toEntity(servicioDTO)));
    }

    public ServicioDTO aceptar(Integer id) {
        return servicioMapper.toDto(servicioService.aceptar(id));
    }

    public void rechazar(Integer id) {
        servicioService.rechazar(id);
    }
}
