package pe.edu.upc.studenthome.controller;
import java.util.ArrayList;
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
import pe.edu.upc.studenthome.models.entities.CalificacionRoommate;
import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.models.entities.Puntaje;
import pe.edu.upc.studenthome.service.ArrendadorServices;
import pe.edu.upc.studenthome.service.CalificacionRoommateService;
import pe.edu.upc.studenthome.service.CalificacionService;
import pe.edu.upc.studenthome.service.EstudianteService;
import pe.edu.upc.studenthome.service.PuntajeService;

@Controller
@RequestMapping("/calificacionRoommate")
public class CalificacionRoommateController {

	@Autowired
	private CalificacionRoommateService calificacionRoommateService;
	

	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private PuntajeService puntajeService;
	
	@GetMapping
	public String inicio(Model model) {
		CalificacionRoommate calificacionRoommate = new CalificacionRoommate();
		
		try {
			//List<Calificacion> calificacion = calificacionService.findAll();
			//model.addAttribute("calificaciones", calificaciones);
			model.addAttribute("calificacionRoommate", calificacionRoommate);
			List<Estudiante> estudiantes = estudianteService.findAll();
			List<Estudiante> roommates =new ArrayList<Estudiante>();
			for(Estudiante estudiante:estudiantes) {
				if("Si".equals(estudiante.getRoomate())) {
					roommates.add(estudiante);
				}
			}
			model.addAttribute("roommates", roommates);
			List<Puntaje> puntajes = puntajeService.findAll();
			model.addAttribute("puntajes", puntajes);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "calificaciones/roommate";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("calificacionRoommate") CalificacionRoommate calificacionRoommate, SessionStatus status) {
		try {	
			calificacionRoommateService.save(calificacionRoommate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping 
		return "redirect:/calificaciones/roommate";
	}
	
}
