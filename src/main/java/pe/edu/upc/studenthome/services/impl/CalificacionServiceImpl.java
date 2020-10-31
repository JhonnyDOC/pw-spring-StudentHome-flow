package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.models.entities.Calificacion;
import pe.edu.upc.studenthome.models.repositories.CalificacionRepository;
import pe.edu.upc.studenthome.service.CalificacionService;

@Service
public class CalificacionServiceImpl implements CalificacionService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CalificacionRepository calificacionRepository;

	@Transactional
	@Override
	public Calificacion save(Calificacion entity) throws Exception {
		// TODO Auto-generated method stub
		return calificacionRepository.save(entity);
	}

	@Transactional
	@Override
	public Calificacion update(Calificacion entity) throws Exception {
		// TODO Auto-generated method stub
		return calificacionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		calificacionRepository.deleteById(id);
	}

	
	@Override
	public Optional<Calificacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Calificacion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	}




