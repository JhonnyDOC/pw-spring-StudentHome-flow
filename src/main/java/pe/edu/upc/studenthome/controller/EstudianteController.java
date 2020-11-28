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

import pe.edu.upc.studenthome.models.entities.Estudiante;
import pe.edu.upc.studenthome.service.EstudianteService;

@Controller
@RequestMapping("/estudiantes")
@SessionAttributes("estudiante")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping
	public String inicio(Model model) {
		Estudiante estudiante = new Estudiante();
		
		try {
			List<Estudiante> estudiantes = estudianteService.findAll();
			model.addAttribute("estudiantes", estudiantes);
			model.addAttribute("estudiante", estudiante);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/estudiantes/perfilestudiante";

	}
	
	@GetMapping("registro")
	public String Registro(Model model) {
		Estudiante estudiante = new Estudiante();
		
		try {
			List<Estudiante> estudiantes = estudianteService.findAll();
			model.addAttribute("estudiantes", estudiantes);
			model.addAttribute("estudiante", estudiante);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/estudiantes/registro";

	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("estudiante") Estudiante estudiante, SessionStatus status) {
		try {
			estudianteService.save(estudiante);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping 
		return "redirect:/estudiantes";
	}
	
	@PostMapping("cancel")
	public String cancel() {
		
		return "/";
	}
	
	
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		try {
			Optional<Estudiante> optional = estudianteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("estudiante", optional.get());
				return "estudiantes/registro";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/estudiantes";
	}
	
	@GetMapping ("/modificar/{id}")
	public String modificar (@PathVariable long id, Model model) {
		try {
			Optional<Estudiante> estudiante=estudianteService.findById(id);
			System.out.println("tag" + estudiante.get().getPersona().getNombrePersona());
			model.addAttribute("estudiante", estudiante.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/estudiantes/modificar";
	}
	
}