package pe.edu.upc.studenthome.services.impl;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.TipoComprobante;
import pe.edu.upc.studenthome.models.repositories.TipoComprobanteRepository;
import pe.edu.upc.studenthome.service.TipoComprobanteService;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoComprobanteRepository tipoComprobanteRepository;

	@Transactional
	@Override
	public TipoComprobante save(TipoComprobante entity) throws Exception {
		return tipoComprobanteRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoComprobante update(TipoComprobante entity) throws Exception {
		return tipoComprobanteRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tipoComprobanteRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public Optional<TipoComprobante> findById(Integer id) throws Exception {
		return tipoComprobanteRepository.findById(id);
	}

	@Transactional
	@Override
	public List<TipoComprobante> findAll() throws Exception {
		return tipoComprobanteRepository.findAll();
	}
	
	
}
