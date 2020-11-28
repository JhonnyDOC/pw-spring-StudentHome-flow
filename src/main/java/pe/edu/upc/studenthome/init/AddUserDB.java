package pe.edu.upc.studenthome.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.studenthome.models.entities.Usuario;
import pe.edu.upc.studenthome.models.repositories.AuthorityRepository;
import pe.edu.upc.studenthome.models.repositories.UsuarioRepository;
import pe.edu.upc.studenthome.utils.Segmento;

@Service
public class AddUserDB implements CommandLineRunner{


	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	/*	
	//creando el objeto que cifra las contraseñas	
	BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	String password = bcpe.encode("estudiante");
		
	
		Usuario estudiante1 = new Usuario();
		estudiante1.setUsername("estudiante2");
		estudiante1.setPassword(password);
		estudiante1.setSegmento(Segmento.ESTUDIANTE);
		estudiante1.setIdSegmento(2);
		estudiante1.setEnable(true);
		
		Usuario estudiante2 = new Usuario();
		estudiante2.setUsername("estudiante3");
		estudiante2.setPassword(password);
		estudiante2.setSegmento(Segmento.ESTUDIANTE);
		estudiante2.setIdSegmento(3);
		estudiante2.setEnable(true);
		
		Usuario estudiante3 = new Usuario();
		estudiante3.setUsername("estudiante7");
		estudiante3.setPassword(password);
		estudiante3.setSegmento(Segmento.ESTUDIANTE);
		estudiante3.setIdSegmento(7);
		estudiante3.setEnable(true);
		
		BCryptPasswordEncoder bcpeArren = new BCryptPasswordEncoder();
		String passwordArrendador = bcpeArren.encode("arrendador");
			
			Usuario arrendador1 = new Usuario();
			arrendador1.setUsername("arrendador1");
			arrendador1.setPassword(passwordArrendador);
			arrendador1.setSegmento(Segmento.ARRENDADOR);
			arrendador1.setIdSegmento(1);
			arrendador1.setEnable(true);
			
			Usuario arrendador2 = new Usuario();
			arrendador2.setUsername("arrendador4");
			arrendador2.setPassword(passwordArrendador);
			arrendador2.setSegmento(Segmento.ARRENDADOR);
			arrendador2.setIdSegmento(4);
			arrendador2.setEnable(true);
			
			Usuario arrendador3 = new Usuario();
			arrendador3.setUsername("arrendador5");
			arrendador3.setPassword(passwordArrendador);
			arrendador3.setSegmento(Segmento.ARRENDADOR);
			arrendador3.setIdSegmento(5);
			arrendador3.setEnable(true);
			
			estudiante1.addAuthority("ROLE_ESTUDIANTE");
			estudiante2.addAuthority("ROLE_ESTUDIANTE");
			estudiante3.addAuthority("ROLE_ESTUDIANTE");
			
			arrendador1.addAuthority("ROLE_ARRENDADOR");
			arrendador2.addAuthority("ROLE_ARRENDADOR");
			arrendador3.addAuthority("ROLE_ARRENDADOR");
			
			usuarioRepository.save(estudiante1);	
			usuarioRepository.save(estudiante2);	
			usuarioRepository.save(estudiante3);	
			
			usuarioRepository.save(arrendador1);	
			usuarioRepository.save(arrendador2);
			usuarioRepository.save(arrendador3);
			*/
	}

}
