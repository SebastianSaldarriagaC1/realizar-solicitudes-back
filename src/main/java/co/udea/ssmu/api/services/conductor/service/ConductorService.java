package co.udea.ssmu.api.services.conductor.service;

import co.udea.ssmu.api.model.jpa.model.conductor.Conductor;
import co.udea.ssmu.api.model.jpa.repository.conductor.IConductorRepository;
import co.udea.ssmu.api.utils.common.Messages;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ConductorService {
    private final IConductorRepository conductorRepository;
    private final Messages messages;

    public ConductorService(IConductorRepository conductorRepository, Messages messages){
        this.conductorRepository = conductorRepository;
        this.messages = messages;
    }

    public List<Conductor> getAllConductores(){
        return conductorRepository.findAll();
    }

    //Método utilizado para simular la asignación de un conductor
    public Conductor getRandomConductor(){
        Random random = new Random();
        List<Conductor> list = getAllConductores();
        int indice = random.nextInt(list.size());
        return list.get(indice);
    }
}
