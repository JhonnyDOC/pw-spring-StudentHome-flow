package pe.edu.upc.studenthome.controller;

import java.util.List;
import java.util.Optional;

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

import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.entities.Ciudad;
import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.models.entities.Habitacion;
import pe.edu.upc.studenthome.service.ArrendadorServices;
import pe.edu.upc.studenthome.service.DistritoService;
import pe.edu.upc.studenthome.service.HabitacionService;

@Controller
@RequestMapping("/habitaciones")

public class HabitacionController {

	@Autowired
	private DistritoService distritoService;
	
	@Autowired
	private ArrendadorServices arrendadorService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@GetMapping
	public String inicio(Model model , String keyword) {
		Habitacion habitacion = new Habitacion();
		
		List<Habitacion> habitaciones;
		
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
			model.addAttribute("habitaciones", habitaciones);
			model.addAttribute("habitacion", habitacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/habitaciones/inicio";
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

