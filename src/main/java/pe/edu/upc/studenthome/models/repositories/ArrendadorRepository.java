package pe.edu.upc.studenthome.models.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Arrendador;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrendadorRepository extends JpaRepository<Arrendador, Long> {
	//List<Arrendador> findByNombrePersonaLike(String nombrePersona) throws Exception;
	//List<Arrendador> findByApellidoPersonaLike(String apellidoPersona) throws Exception;
	//Optional<Arrendador> findByDni(String dni) throws Exception;
}

