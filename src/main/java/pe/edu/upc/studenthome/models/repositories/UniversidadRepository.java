package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.studenthome.models.entities.Universidad;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer>{
	List<Universidad> findByNombreUniversidadLike(String nombreUniversidad) throws Exception;
}