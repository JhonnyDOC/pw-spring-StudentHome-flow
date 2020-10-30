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

import pe.edu.upc.studenthome.models.entities.Ciudad;
import pe.edu.upc.studenthome.service.CiudadService;

@Controller
@RequestMapping("/ciudades")
@SessionAttributes("ciudad")
public class CiudadController {
	
	@Autowired
	private CiudadService ciudadService;
	
	@GetMapping
	public String inicio(Model model) {
		Ciudad ciudad = new Ciudad();
		
		try {
			List<Ciudad> ciudades = ciudadService.findAll();
			model.addAttribute("ciudades", ciudades);
			model.addAttribute("ciudad", ciudad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/ciudades/registro";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("ciudad") Ciudad ciudad, SessionStatus status) {
		try {
			ciudadService.save(ciudad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/ciudades";
	}
	
	@PostMapping("cancel")
	public String cancel() {
		return "redirect:/login";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Ciudad> optional = ciudadService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("ciudad", optional.get());
				return "ciudades/view";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/ciudades";
	}
	
}
