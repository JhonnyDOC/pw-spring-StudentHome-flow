package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.Renta;
import org.springframework.stereotype.Repository;

@Repository
public interface RentaRepository extends JpaRepository<Renta, Integer> {
	
}
