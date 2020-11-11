package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.repositories.ArrendadorRepository;
import pe.edu.upc.studenthome.models.repositories.PersonaRepository;
import pe.edu.upc.studenthome.service.ArrendadorServices;

@Service
public class ArrendadorServiceImpl implements ArrendadorServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArrendadorRepository arrendadorRepository;
	
	@Autowired
	private PersonaRepository personaRepository;

	@Transactional
	@Override
	public Arrendador save(Arrendador entity) throws Exception {
		personaRepository.save(entity.getPersona());
		return arrendadorRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Arrendador update(Arrendador entity) throws Exception {
		personaRepository.save(entity.getPersona());
		return arrendadorRepository.save(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		arrendadorRepository.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Arrendador> findById(Long id) throws Exception {
		return arrendadorRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Arrendador> findAll() throws Exception {
		return arrendadorRepository.findAll();
	}

	/*
	@Override
	public List<Arrendador> findByNombre(String nombrePersona) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	/*
	@Transactional(readOnly = true)
	@Override
	public List<Arrendador> findByNombre(String nombrePersona) throws Exception {
		return arrendadorRepository.findByNombrePersonaLike(nombrePersona);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Arrendador> findByApellido(String apellidoPersona) throws Exception {
		return arrendadorRepository.findByApellidoPersonaLike(apellidoPersona);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Arrendador> findBydni(String dni) throws Exception {
		return arrendadorRepository.findByDni(dni);
	}
	*/

}
