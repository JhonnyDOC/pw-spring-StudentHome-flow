package pe.edu.upc.studenthome.service;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.models.entities.Habitacion;

import java.util.List;

import pe.edu.upc.studenthome.models.entities.Habitacion;

public interface HabitacionService extends CrudService<Habitacion, Integer>{
	List<Habitacion> findPorDistrito(String nombreDistrito) throws Exception;
	
}
