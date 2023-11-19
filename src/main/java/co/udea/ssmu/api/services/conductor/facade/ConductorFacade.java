package co.udea.ssmu.api.services.conductor.facade;

import co.udea.ssmu.api.model.jpa.dto.conductor.ConductorDTO;
import co.udea.ssmu.api.model.jpa.mapper.conductor.ConductorMapper;
import co.udea.ssmu.api.services.conductor.service.ConductorService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ConductorFacade {
    private final ConductorService conductorService;
    private final ConductorMapper conductorMapper;

    public ConductorFacade(ConductorService conductorService, ConductorMapper conductorMapper){
        this.conductorMapper = conductorMapper;
        this.conductorService = conductorService;
    }

    public List<ConductorDTO> getAllConductores(){
        return conductorMapper.toDto(conductorService.getAllConductores());
    }

    public ConductorDTO getRandomConductor(){
        return conductorMapper.toDto(conductorService.getRandomConductor());
    }
}
