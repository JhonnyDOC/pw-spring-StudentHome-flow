package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.studenthome.models.entities.Universidad;
import pe.edu.upc.studenthome.models.repositories.UniversidadRepository;
import pe.edu.upc.studenthome.service.UniversidadService;

@Service
public class UniversidadServiceImpl implements UniversidadService, Serializable{

	
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private UniversidadRepository universidadRepository;
	
	@Transactional
	@Override
	public Universidad save(Universidad entity) throws Exception {
		// TODO Auto-generated method stub
		return universidadRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Universidad update(Universidad entity) throws Exception {
		// TODO Auto-generated method stub
		return universidadRepository.save(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		universidadRepository.deleteById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Universidad> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return universidadRepository.findById(id);
	}

	@Override
	public List<Universidad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return universidadRepository.findAll();
	}

	@Override
	public List<Universidad> findByNombre(String nombreUniversidad) throws Exception {
		// TODO Auto-generated method stub
		return universidadRepository.findByNombreUniversidadLike(nombreUniversidad);
	}

}
