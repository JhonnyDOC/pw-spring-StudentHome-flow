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

import pe.edu.upc.studenthome.models.entities.Servicio;
import pe.edu.upc.studenthome.service.ServicioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping
	public String inicio(Model model) {
		Servicio servicio = new Servicio();
		
		try {
			//List<Servicio> servicios = servicioService.findAll();
			//model.addAttribute("servicios", servicios);
			model.addAttribute("servicio", servicio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/servicios/registro";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("servicio") Servicio servicio, SessionStatus status) {
		try {
			servicioService.save(servicio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping 
		return "redirect:/servicios";
	}
	
}