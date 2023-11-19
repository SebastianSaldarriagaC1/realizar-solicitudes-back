package co.udea.ssmu.api.services.servicio.facade;

import co.udea.ssmu.api.model.jpa.dto.conductor.ConductorDTO;
import co.udea.ssmu.api.model.jpa.dto.servicio.ServicioDTO;
import co.udea.ssmu.api.model.jpa.mapper.conductor.ConductorMapper;
import co.udea.ssmu.api.model.jpa.mapper.servicio.ServicioMapper;
import co.udea.ssmu.api.model.jpa.mapper.ubicacion.UbicacionMapper;
import co.udea.ssmu.api.model.jpa.model.ubicacion.Ubicacion;
import co.udea.ssmu.api.services.conductor.facade.ConductorFacade;
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
    private final ConductorFacade conductorFacade;
    private final ConductorMapper conductorMapper;

    public ServicioFacade(ServicioService servicioService, ServicioMapper servicioMapper,
                          UbicacionService ubicacionService, UbicacionMapper ubicacionMapper,
                          ConductorFacade conductorFacade, ConductorMapper conductorMapper) {
        this.servicioService = servicioService;
        this.servicioMapper = servicioMapper;
        this.ubicacionService = ubicacionService;
        this.ubicacionMapper = ubicacionMapper;
        this.conductorFacade = conductorFacade;
        this.conductorMapper = conductorMapper;
    }

    public ServicioDTO solicitar(ServicioDTO servicio) {
        Ubicacion origenEntity = ubicacionService.create(ubicacionMapper.toEntity(servicio.getUbicacionOrigen()));
        Ubicacion destinoEntity = ubicacionService.create(ubicacionMapper.toEntity(servicio.getUbicacionDestino()));

        servicio.getUbicacionOrigen().setIdUbicacion(origenEntity.getIdUbicacion());
        servicio.getUbicacionDestino().setIdUbicacion(destinoEntity.getIdUbicacion());

        // Método para calcular el precio (Se debería cambiar si se llegan a integrar los demás módulos)
        servicio.setCosto(servicioService.getCostoRandom());

        return servicioMapper.toDto(servicioService.create(servicioMapper.toEntity(servicio)));
    }

    public ServicioDTO aceptarSolicitudServicio(Integer id) {
        return servicioMapper.toDto(servicioService.aceptarSolicitudServicio(id));
    }

    public void rechazarSolicitudServicio(Integer id) {
        servicioService.rechazarSolicitudServicio(id);
    }

    public Double getCostoById(Integer id){
        return servicioService.getCostoById(id);
    }

    public ServicioDTO getServicioById(Integer id){
        return servicioMapper.toDto(servicioService.getServicioById(id));
    }

    public ServicioDTO aceptarConductor(Integer idServicio, Integer idConductor){
        return servicioMapper.toDto(servicioService.aceptarConductor(idServicio, idConductor));
    }

    public ConductorDTO rechazarConductor(){
        return conductorFacade.getRandomConductor();
    }
}
