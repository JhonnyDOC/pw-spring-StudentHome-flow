package pe.edu.upc.studenthome.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.models.entities.Habitacion;
import pe.edu.upc.studenthome.models.repositories.HabitacionRepository;
import pe.edu.upc.studenthome.service.HabitacionService;

@Service
public class HabitacionServiceImpl implements HabitacionService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private HabitacionRepository habitacionRepository;

	@Transactional
	@Override
	public Habitacion save(Habitacion entity) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.save(entity);
	}

	@Transactional
	@Override
	public Habitacion update(Habitacion entity) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		habitacionRepository.deleteById(id);
	}

	
	@Override
	public Optional<Habitacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.findById(id);
	}

	@Override
	public List<Habitacion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.findAll();
	}

	@Override
	public List<Habitacion> findPorDistrito(String nombreDistrito) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.findPorDistrito(nombreDistrito);
	}



	}



