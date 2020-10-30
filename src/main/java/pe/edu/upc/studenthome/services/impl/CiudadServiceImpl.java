package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.Ciudad;
import pe.edu.upc.studenthome.models.repositories.CiudadRepository;
import pe.edu.upc.studenthome.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService, Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Transactional
	@Override
	public Ciudad save(Ciudad entity) throws Exception {
		// TODO Auto-generated method stub
		return ciudadRepository.save(entity);
	}

	@Transactional
	@Override
	public Ciudad update(Ciudad entity) throws Exception {
		// TODO Auto-generated method stub
		return ciudadRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		ciudadRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Ciudad> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return ciudadRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ciudad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return ciudadRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ciudad> findByNombre(String nombreCiudad) throws Exception {
		// TODO Auto-generated method stub
		return ciudadRepository.findByNombreCiudadContaining(nombreCiudad);
	}

}
