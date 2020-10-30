package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.Puntaje;
import pe.edu.upc.studenthome.models.repositories.PuntajeRepository;
import pe.edu.upc.studenthome.service.PuntajeService;

@Service
public class PuntajeServiceImpl implements PuntajeService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PuntajeRepository puntajeRepository;

	@Transactional
	@Override
	public Puntaje save(Puntaje entity) throws Exception {
		return puntajeRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Puntaje update(Puntaje entity) throws Exception {
		return puntajeRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		puntajeRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public Optional<Puntaje> findById(Integer id) throws Exception {
		return puntajeRepository.findById(id);
	}

	@Transactional
	@Override
	public List<Puntaje> findAll() throws Exception {
		return puntajeRepository.findAll();
	}
	
}