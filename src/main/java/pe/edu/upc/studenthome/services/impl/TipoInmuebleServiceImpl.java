package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.TipoInmueble;
import pe.edu.upc.studenthome.models.repositories.TipoInmuebleRepository;
import pe.edu.upc.studenthome.service.TipoInmuebleService;

@Service
public class TipoInmuebleServiceImpl implements TipoInmuebleService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoInmuebleRepository tipoInmuebleRepository;
	
	@Transactional
	@Override
	public TipoInmueble save(TipoInmueble entity) throws Exception {
		return tipoInmuebleRepository.save(entity);
	}

	@Override
	public TipoInmueble update(TipoInmueble entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<TipoInmueble> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoInmueble> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoInmuebleRepository.findAll();
	}
}
