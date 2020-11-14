package pe.edu.upc.studenthome.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.thymeleaf.expression.Lists;
import org.thymeleaf.util.ListUtils;

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
@RequestMapping("/habitaciones")

public class HabitacionController {

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
	public String inicio(Model model , String keyword) {
		Habitacion habitacion = new Habitacion();
		
		List<Habitacion> habitaciones;
		List<List<Habitacion>> partitions;
		try {
			if (keyword!=null)
			{
				habitaciones=habitacionService.findPorDistrito(keyword);
			}
			else
			{
				habitaciones = habitacionService.findAll();
			}
			
			List<Distrito> distritos = distritoService.findAll();
			model.addAttribute("distritos", distritos);
			List<Arrendador> arrendadores = arrendadorService.findAll();
			model.addAttribute("arrendadores", arrendadores);
			
			List<TipoInmueble> tipoInmuebles = tipoInmuebleService.findAll();
			model.addAttribute("tipoInmuebles", tipoInmuebles);
			
			List<Universidad> universidades = universidadService.findAll();
			model.addAttribute("universidades", universidades);
			
			
			model.addAttribute("habitaciones", habitaciones);
			model.addAttribute("habitacion", habitacion);
			partitions= org.apache.commons.collections4.ListUtils.partition(habitaciones, 2);
			// th:with="partitions=${T(org.apache.commons.collections4.ListUtils).partition(habitaciones, 2)}"
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/index";
	}
	@PostMapping("save")
	public String save(@ModelAttribute("habitacion") Habitacion habitacion, SessionStatus status) {
		try {
			habitacionService.save(habitacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping 
		return "redirect:/habitaciones";
	}
	
}

