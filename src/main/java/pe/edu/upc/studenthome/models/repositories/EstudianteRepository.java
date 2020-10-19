package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Estudiante;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	List<Estudiante> findByNombrePersona(String nombrePersona) throws Exception;
	List<Estudiante> findByApellidoPersona(String apellidoPersona) throws Exception;
	Optional<Estudiante> findByDni(String dni) throws Exception;
}
