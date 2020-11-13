package pe.edu.upc.studenthome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.entities.Calificacion;
import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.models.entities.Puntaje;
import pe.edu.upc.studenthome.service.ArrendadorServices;
import pe.edu.upc.studenthome.service.CalificacionService;
import pe.edu.upc.studenthome.service.EstudianteService;
import pe.edu.upc.studenthome.service.PuntajeService;

@Controller
@RequestMapping("/calificaciones")
public class CalificacionController {
	
	@Autowired
	private CalificacionService calificacionService;
	
	@Autowired
	private ArrendadorServices arrendadorService;
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private PuntajeService puntajeService;
	
	@GetMapping
	public String inicio(Model model) {
		Calificacion calificacion = new Calificacion();
		
		try {
			//List<Calificacion> calificacion = calificacionService.findAll();
			//model.addAttribute("calificaciones", calificaciones);
			model.addAttribute("calificacion", calificacion);
			List<Arrendador> arrendadores = arrendadorService.findAll();
			model.addAttribute("arrendadores", arrendadores);
			List<Estudiante> estudiantes = estudianteService.findAll();
			model.addAttribute("estudiantes", estudiantes);
			List<Puntaje> puntajes = puntajeService.findAll();
			model.addAttribute("puntajes", puntajes);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/calificaciones/inicio";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("calificacion") Calificacion calificacion, SessionStatus status) {
		try {	
			calificacionService.save(calificacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping 
		return "redirect:/calificaciones";
	}
	
}
