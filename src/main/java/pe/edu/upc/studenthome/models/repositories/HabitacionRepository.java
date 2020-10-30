package pe.edu.upc.studenthome.models.repositories;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.models.entities.Habitacion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
	
	  @Query("SELECT h FROM Habitacion h WHERE h.direccion LIKE %?1%")
	List<Habitacion> findPorDistrito(String nombreDistrito) throws Exception;
	
}
