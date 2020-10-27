package pe.edu.upc.studenthome.models.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	List<Persona> findByNombrePersona(String nombrePersona) throws Exception;
	List<Persona> findByApellidoPersona(String apellidoPersona) throws Exception;
	Optional<Persona> findByDni(String dni) throws Exception;

}
