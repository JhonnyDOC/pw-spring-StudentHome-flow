package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.TipoPago;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer>{

}
