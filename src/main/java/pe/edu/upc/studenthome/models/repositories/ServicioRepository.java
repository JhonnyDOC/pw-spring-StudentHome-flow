package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.Servicio;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer>{

}
