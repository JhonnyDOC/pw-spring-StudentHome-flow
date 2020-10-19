package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Habitacion;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
	List<Habitacion> findByNombreDistrito(String nombreDistrito) throws Exception;
	List<Habitacion> findByNombreArrendador(String nombreArrendador) throws Exception;
}
