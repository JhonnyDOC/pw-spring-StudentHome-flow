package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import java.util.Optional;

import pe.edu.upc.studenthome.models.entities.Estudiante;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	//List<Estudiante> findByNombrePersonaLike(String nombrePersona) throws Exception;
	//List<Estudiante> findByApellidoPersonaLike(String apellidoPersona) throws Exception;
	//Optional<Estudiante> findByDni(String dni) throws Exception;
}

