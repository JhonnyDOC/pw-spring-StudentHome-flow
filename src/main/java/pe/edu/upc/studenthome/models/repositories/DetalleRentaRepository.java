package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.DetalleRenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRentaRepository extends JpaRepository<DetalleRenta, Integer> {
	
}
