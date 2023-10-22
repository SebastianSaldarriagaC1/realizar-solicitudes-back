package co.udea.ssmu.api.services.servicio.service;

import co.udea.ssmu.api.model.jpa.model.jpa.servicio.Servicio;
import co.udea.ssmu.api.model.jpa.repository.servicio.IServicioRepository;
import co.udea.ssmu.api.utils.common.Messages;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ServicioService {

    private final IServicioRepository servicioRepository;
    private final Messages messages;

    public ServicioService(IServicioRepository servicioRepository, Messages messages){
        this.servicioRepository = servicioRepository;
        this.messages = messages;
    }

    public Servicio solicitar(Servicio servicio){
        return servicio;
    }

    public Servicio aceptar(Servicio servicio){
        return servicio;
    }

    public void rechazar(Integer id){

    }
}
