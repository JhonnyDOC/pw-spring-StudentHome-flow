package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.Renta;
import pe.edu.upc.studenthome.models.repositories.RentaRepository;
import pe.edu.upc.studenthome.service.RentaService;

@Service
public class RentaServiceImpl implements RentaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RentaRepository rentaRepository;
	
	@Transactional
	@Override
	public Renta save(Renta entity) throws Exception {
		return rentaRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Renta update(Renta entity) throws Exception {
		return rentaRepository.save(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		rentaRepository.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Renta> findById(Integer id) throws Exception {
		return rentaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Renta> findAll() throws Exception {
		return rentaRepository.findAll();
	}
	
}
