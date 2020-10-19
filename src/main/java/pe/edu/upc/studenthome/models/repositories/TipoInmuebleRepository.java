package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.TipoInmueble;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoInmuebleRepository extends JpaRepository<TipoInmueble, Integer>{

}
