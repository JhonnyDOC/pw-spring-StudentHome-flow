package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.HabitacionServicio;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionServicioRepository extends JpaRepository<HabitacionServicio, Integer> {
	
}
