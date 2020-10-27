package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Habitacion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
	//List<Habitacion> findByNombreDistritoLike(String nombreDistrito) throws Exception;
	//List<Habitacion> findByNombreArrendadorContaining(String nombreArrendador) throws Exception;
}
