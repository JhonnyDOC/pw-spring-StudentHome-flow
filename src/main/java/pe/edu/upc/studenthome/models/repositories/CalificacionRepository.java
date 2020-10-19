package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.Calificacion;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{

}
