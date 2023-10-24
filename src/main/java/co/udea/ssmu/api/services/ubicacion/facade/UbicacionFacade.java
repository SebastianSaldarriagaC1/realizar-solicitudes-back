package co.udea.ssmu.api.services.ubicacion.facade;

import co.udea.ssmu.api.model.jpa.dto.ubicacion.UbicacionDTO;
import co.udea.ssmu.api.model.jpa.mapper.ubicacion.UbicacionMapper;
import co.udea.ssmu.api.model.jpa.model.ubicacion.Ubicacion;
import co.udea.ssmu.api.services.ubicacion.service.UbicacionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UbicacionFacade {

    private final UbicacionService ubicacionService;
    private final UbicacionMapper ubicacionMapper;

    public UbicacionFacade(UbicacionService ubicacionService, UbicacionMapper ubicacionMapper){
        this.ubicacionService = ubicacionService;
        this.ubicacionMapper = ubicacionMapper;
    }

    public Ubicacion create(Ubicacion ubicacionDTO){
        return ubicacionService.create(ubicacionDTO);
    }

    public Ubicacion update(Integer id){
        return ubicacionService.update(id);
    }

    public List<Ubicacion> findAll(){
        return ubicacionService.findAll();
    }

    public Ubicacion findByDireccion(String direccion){
        return ubicacionService.findByDireccion(direccion);
    }

    public void delete(Integer id){
        ubicacionService.delete(id);
    }
}
