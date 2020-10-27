package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.models.repositories.EstudianteRepository;
import pe.edu.upc.studenthome.models.repositories.PersonaRepository;
import pe.edu.upc.studenthome.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Transactional
	@Override
	public Estudiante save(Estudiante entity) throws Exception {
		personaRepository.save(entity.getPersona());
		return estudianteRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Estudiante update(Estudiante entity) throws Exception {
		personaRepository.save(entity.getPersona());
		return estudianteRepository.save(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		estudianteRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Estudiante> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Estudiante> findAll() throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findAll();
	}

	/*
	@Transactional(readOnly = true)
	@Override
	public Optional<Estudiante> findBydni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findByDni(dni);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Estudiante> findByNombre(String nombrePersona) throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findByNombrePersonaLike(nombrePersona);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Estudiante> findByApellido(String apellidoPersona) throws Exception {
		// TODO Auto-generated method stub
		return estudianteRepository.findByApellidoPersonaLike(apellidoPersona);
	}
	*/
	
}
