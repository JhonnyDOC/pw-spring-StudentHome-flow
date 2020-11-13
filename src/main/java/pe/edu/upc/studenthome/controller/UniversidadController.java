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

import pe.edu.upc.studenthome.models.entities.Universidad;
import pe.edu.upc.studenthome.service.UniversidadService;

@Controller
@RequestMapping("/universidades")
@SessionAttributes("universidad")
public class UniversidadController {
	
	@Autowired
	private UniversidadService universidadService;
	
	@GetMapping
	public String inicio(Model model) {
		Universidad universidad = new Universidad();
		
		try {
			List<Universidad> universidades = universidadService.findAll();
			model.addAttribute("universidades", universidades);
			model.addAttribute("universidad", universidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/universidades/registro";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("universidad") Universidad universidad, SessionStatus status) {
		try {
			universidadService.save(universidad);
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
			Optional<Universidad> optional = universidadService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("universidad", optional.get());
				return "universidades/view";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/universidades";
	}
	
}