package pe.edu.upc.studenthome.service;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Ciudad;

public interface CiudadService extends CrudService<Ciudad, Integer>{
	List<Ciudad> findByNombre(String nombreCiudad) throws Exception;
}
