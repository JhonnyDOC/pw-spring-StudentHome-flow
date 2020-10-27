package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.Puntaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntajeRepository extends JpaRepository<Puntaje, Integer>{
	
}
