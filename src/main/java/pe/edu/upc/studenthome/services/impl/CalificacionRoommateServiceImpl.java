package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.models.entities.CalificacionRoommate;
import pe.edu.upc.studenthome.models.repositories.CalificacionRoommateRepository;
import pe.edu.upc.studenthome.service.CalificacionRoommateService;

@Service
public class CalificacionRoommateServiceImpl implements CalificacionRoommateService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CalificacionRoommateRepository calificacionRoommateRepository;

	@Transactional
	@Override
	public CalificacionRoommate save(CalificacionRoommate entity) throws Exception {
		// TODO Auto-generated method stub
		return calificacionRoommateRepository.save(entity);
	}

	@Transactional
	@Override
	public CalificacionRoommate update(CalificacionRoommate entity) throws Exception {
		// TODO Auto-generated method stub
		return calificacionRoommateRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		calificacionRoommateRepository.deleteById(id);
	}
	@Transactional
	@Override
	public Optional<CalificacionRoommate> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalificacionRoommate> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
