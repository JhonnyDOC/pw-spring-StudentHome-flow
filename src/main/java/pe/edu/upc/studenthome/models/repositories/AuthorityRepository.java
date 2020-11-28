package pe.edu.upc.studenthome.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.studenthome.models.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	
}
