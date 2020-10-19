package pe.edu.upc.studenthome.models.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studenthome.models.entities.Distrito;


@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer>{
	List<Distrito> findByNombreDistrito(String nombreDistrito) throws Exception;
}
