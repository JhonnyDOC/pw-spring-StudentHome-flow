package pe.edu.upc.studenthome.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.studenthome.models.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsername( String username ) throws Exception;
}