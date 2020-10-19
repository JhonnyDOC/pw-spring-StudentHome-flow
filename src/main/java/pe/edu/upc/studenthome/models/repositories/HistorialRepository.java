package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.Historial;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer>{
	
}
