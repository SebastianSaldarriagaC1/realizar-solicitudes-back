package co.udea.ssmu.api.services.servicio.service;

import co.udea.ssmu.api.model.jpa.model.conductor.Conductor;
import co.udea.ssmu.api.model.jpa.model.servicio.Servicio;
import co.udea.ssmu.api.model.jpa.repository.conductor.IConductorRepository;
import co.udea.ssmu.api.model.jpa.repository.servicio.IServicioRepository;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioService {

    private final IServicioRepository servicioRepository;
    private final IConductorRepository conductorRepository;
    private final Messages messages;

    public ServicioService(IServicioRepository servicioRepository, Messages messages,
                            IConductorRepository conductorRepository) {
        this.servicioRepository = servicioRepository;
        this.conductorRepository = conductorRepository;
        this.messages = messages;
    }

    public Servicio create(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio update(Servicio s) {
        Servicio existingServicio = servicioRepository.findById(s.getIdServicio()).orElse(null);

        if (existingServicio != null) {
            existingServicio.setUsuario(s.getUsuario());
            existingServicio.setConductor(s.getConductor());
            existingServicio.setUbicacionOrigen(s.getUbicacionOrigen());
            existingServicio.setUbicacionDestino(s.getUbicacionDestino());
            existingServicio.setFechaInicio(s.getFechaInicio());
            existingServicio.setFechaFin(s.getFechaFin());
            existingServicio.setEstado(s.getEstado());
            existingServicio.setDetalles(s.getDetalles());
            existingServicio.setEstadoPago(s.getEstadoPago());
            existingServicio.setCalificacionConductor(s.getCalificacionConductor());
            existingServicio.setCalificacionUsuario(s.getCalificacionUsuario());
            existingServicio.setCosto(s.getCosto());

            return servicioRepository.save(existingServicio);
        } else {
            return null;
        }
    }

    public Servicio findById(Integer id){
        return servicioRepository.findById(id).orElse(null);
    }

    public Servicio aceptarSolicitudServicio(Integer id) {
        Optional<Servicio> servicioAux = servicioRepository.findById(id);

        Servicio servicio = servicioAux.orElseThrow(() -> new BusinessException(messages.get("servicio.does.not.exist")));

        servicio.setEstado("Aceptado");
        return servicioRepository.save(servicio);
    }

    public void rechazarSolicitudServicio(Integer id) {
        servicioRepository.findById(id)
                .orElseThrow(() -> new BusinessException(String.format(messages.get("servicio.delete.find.error"), id)));
        servicioRepository.deleteById(id);
    }

    //Bad optimization. It would be better to create a method at servicioRepository that returns Costo directly
    public Double getCostoById(Integer id){
        Optional<Servicio> servicioAux = servicioRepository.findById(id);

        Servicio servicio = servicioAux.orElseThrow(() -> new BusinessException(messages.get("servicio.does.not.exist")));

        return servicio.getCosto();
    }

    public Servicio getServicioById(Integer id){
        Optional<Servicio> servicioAux = servicioRepository.findById(id);

        return servicioAux.orElseThrow(() -> new BusinessException(messages.get("servicio.does.not.exist")));
    }

    public Servicio aceptarConductor(Integer servicioId, Integer conductorId) {
        Servicio servicio = servicioRepository.findById(servicioId)
                .orElseThrow(() -> new BusinessException(messages.get("servicio.do.not.found")));

        Conductor conductor = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new BusinessException(messages.get("conductor.do.not.found")));

        servicio.setConductor(conductor);

        return servicioRepository.save(servicio);
    }

    //Servicios no necesarios, añadidos únicamente como demostración
    public Double getCostoRandom(){
        Random rand = new Random();

        int rango = (25000 - 5000) / 100;

        return (rand.nextDouble(rango) + 5000 / 100) * 100;
    }
}