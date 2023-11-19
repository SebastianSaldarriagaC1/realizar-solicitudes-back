package co.udea.ssmu.api.services.usuario.service;

import co.udea.ssmu.api.model.jpa.model.servicio.Servicio;
import co.udea.ssmu.api.model.jpa.model.usuario.Usuario;
import co.udea.ssmu.api.model.jpa.repository.usuario.IUsuarioRepository;
import co.udea.ssmu.api.utils.common.Messages;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final Messages messages;

    public UsuarioService(IUsuarioRepository usuarioRepository, Messages messages){
        this.messages = messages;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Servicio> getHistorialServiciosByUsuarioId(Integer id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return usuario.getServicios();
        } else {
            return Collections.emptyList();
        }
    }
}
