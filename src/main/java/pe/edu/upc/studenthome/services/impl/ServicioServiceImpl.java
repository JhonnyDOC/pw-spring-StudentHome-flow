package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.Servicio;
import pe.edu.upc.studenthome.models.repositories.ServicioRepository;
import pe.edu.upc.studenthome.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Transactional
	@Override
	public Servicio save(Servicio entity) throws Exception {
		return servicioRepository.save(entity);
	}

	@Override
	public Servicio update(Servicio entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Servicio> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicio> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
