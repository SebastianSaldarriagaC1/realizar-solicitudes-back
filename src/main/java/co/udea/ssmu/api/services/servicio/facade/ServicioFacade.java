package co.udea.ssmu.api.services.servicio.facade;

import co.udea.ssmu.api.model.jpa.dto.conductor.ConductorDTO;
import co.udea.ssmu.api.model.jpa.dto.servicio.ServicioDTO;
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

    public ServicioFacade(ServicioService servicioService, ServicioMapper servicioMapper,
                          UbicacionService ubicacionService, UbicacionMapper ubicacionMapper,
                          ConductorFacade conductorFacade) {
        this.servicioService = servicioService;
        this.servicioMapper = servicioMapper;
        this.ubicacionService = ubicacionService;
        this.ubicacionMapper = ubicacionMapper;
        this.conductorFacade = conductorFacade;
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

    public ServicioDTO aceptar(Integer id) {
        return servicioMapper.toDto(servicioService.aceptar(id));
    }

    public void rechazar(Integer id) {
        servicioService.rechazar(id);
    }

    public Double getCostoById(Integer id){
        return servicioService.getCostoById(id);
    }

    public ServicioDTO getServicioById(Integer id){
        return servicioMapper.toDto(servicioService.getServicioById(id));
    }

    public ServicioDTO asignarConductor(ServicioDTO servicio){
        ConductorDTO conductor = conductorFacade.getRandomConductor();
        servicio.setConductor(conductor);

        //Aplicar un update que aun falta el servicio

        return servicio;
    }
}
