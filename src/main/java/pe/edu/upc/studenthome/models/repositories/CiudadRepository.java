package pe.edu.upc.studenthome.models.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.studenthome.models.entities.Ciudad;
import org.springframework.stereotype.Repository;


@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
	List<Ciudad> findByNombreCiudadContaining(String nombreCiudad) throws Exception;
}
