package pe.edu.upc.studenthome.service;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Universidad;

public interface UniversidadService extends CrudService<Universidad, Integer>{
	List<Universidad> findByNombre(String nombreUniversidad) throws Exception;
}
