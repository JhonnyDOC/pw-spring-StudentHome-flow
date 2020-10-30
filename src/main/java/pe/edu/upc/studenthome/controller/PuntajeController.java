package pe.edu.upc.studenthome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.studenthome.models.entities.Puntaje;
import pe.edu.upc.studenthome.service.PuntajeService;

@Controller
@RequestMapping("/puntajes")
@SessionAttributes("puntaje")
public class PuntajeController {
	
	@Autowired
	private PuntajeService puntajeService;
	
	@GetMapping
	public String registro(Model model) {
		Puntaje puntaje=new Puntaje();
		try {
			List<Puntaje> puntajes = puntajeService.findAll();
		    model.addAttribute("puntajes", puntajes);
			model.addAttribute("puntaje", puntaje); 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.out.println();
		}
		return "/puntajes/registropuntajes";
	}
	
	@PostMapping("save") 
	public String save(@ModelAttribute("puntaje") Puntaje puntaje, SessionStatus status) { 
		try {
			puntajeService.save(puntaje);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/puntajes";
	}

}
