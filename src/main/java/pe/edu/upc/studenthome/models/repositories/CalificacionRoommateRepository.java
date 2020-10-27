package pe.edu.upc.studenthome.models.repositories;

import pe.edu.upc.studenthome.models.entities.CalificacionRoommate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRoommateRepository extends JpaRepository<CalificacionRoommate, Integer>{

}
