package pe.edu.upc.studenthome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.models.entities.Habitacion;
import pe.edu.upc.studenthome.models.entities.TipoInmueble;
import pe.edu.upc.studenthome.models.entities.Universidad;
import pe.edu.upc.studenthome.service.ArrendadorServices;
import pe.edu.upc.studenthome.service.DistritoService;
import pe.edu.upc.studenthome.service.HabitacionService;
import pe.edu.upc.studenthome.service.TipoInmuebleService;
import pe.edu.upc.studenthome.service.UniversidadService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private DistritoService distritoService;
	
	@Autowired
	private ArrendadorServices arrendadorService;
	
	@Autowired
	private TipoInmuebleService tipoInmuebleService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private UniversidadService universidadService;
	
	@GetMapping
	public String index(Model model , String keyword) {
		
		
		return "redirect:/habitaciones";
	}
	
	
}
