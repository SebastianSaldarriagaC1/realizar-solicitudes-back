package co.udea.ssmu.api.model.jpa.repository.ubicacion;

import co.udea.ssmu.api.model.jpa.model.ubicacion.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUbicacionRepository extends JpaRepository<Ubicacion, Integer> {
}
