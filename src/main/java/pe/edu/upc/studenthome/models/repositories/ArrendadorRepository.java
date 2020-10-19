package pe.edu.upc.studenthome.models.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Arrendador;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrendadorRepository extends JpaRepository<Arrendador, Long> {
	List<Arrendador> findByNombrePersona(String nombrePersona) throws Exception;
	List<Arrendador> findByApellidoPersona(String apellidoPersona) throws Exception;
	Optional<Arrendador> findByDni(String dni) throws Exception;
}
