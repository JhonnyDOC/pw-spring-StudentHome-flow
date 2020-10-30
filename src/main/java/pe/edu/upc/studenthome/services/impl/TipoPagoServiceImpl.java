package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.TipoPago;
import pe.edu.upc.studenthome.models.repositories.TipoPagoRepository;
import pe.edu.upc.studenthome.service.TipoPagoService;

@Service
public class TipoPagoServiceImpl implements TipoPagoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TipoPagoRepository tipoPagoRepository;

	@Transactional
	@Override
	public TipoPago save(TipoPago entity) throws Exception {
		return tipoPagoRepository.save(entity);
	}
	
	@Transactional
	@Override
	public TipoPago update(TipoPago entity) throws Exception {
		return tipoPagoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tipoPagoRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public Optional<TipoPago> findById(Integer id) throws Exception {
		return tipoPagoRepository.findById(id);
	}

	@Transactional
	@Override
	public List<TipoPago> findAll() throws Exception {
		return tipoPagoRepository.findAll();
	}
	
}