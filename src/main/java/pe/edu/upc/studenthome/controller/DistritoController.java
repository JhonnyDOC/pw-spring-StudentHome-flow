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

import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.service.DistritoService;


@Controller
@RequestMapping("/distritos")
@SessionAttributes("distrito")
public class DistritoController {
	
	@Autowired
	private DistritoService distritoService;
	
	@GetMapping
	public String inicio(Model model) {
		Distrito distrito = new Distrito();
		
		try {
			List<Distrito> distritos = distritoService.findAll();
			model.addAttribute("distritos", distritos);
			model.addAttribute("distrito", distrito);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/distritos/registro";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("distrito") Distrito distrito, SessionStatus status) {
		try {
			distritoService.save(distrito);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/distritos";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Distrito> optional = distritoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("distrito", optional.get());
				return "distritos/view";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/distritos";
	}
	
}
