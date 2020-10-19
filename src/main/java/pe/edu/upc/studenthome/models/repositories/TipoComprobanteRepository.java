package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.TipoComprobante;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoComprobanteRepository extends JpaRepository<TipoComprobante, Integer>{
	
}
