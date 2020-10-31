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
import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.service.ArrendadorServices;
import pe.edu.upc.studenthome.service.DistritoService;

@Controller
@RequestMapping("/arrendadores")
@SessionAttributes("arrendador")
public class ArrendadorController {
	
	@Autowired
	private ArrendadorServices arrendadorService;
	
	@Autowired
	private DistritoService distritoServices;
	
	@GetMapping
	public String inicio(Model model) {
		Arrendador arrendador = new Arrendador();
		
		try {
			List<Arrendador> arrendadores = arrendadorService.findAll();
			List<Distrito> distritos = distritoServices.findAll();
			model.addAttribute("arrendadores", arrendadores);
			model.addAttribute("distritos", distritos);
			model.addAttribute("arrendador", arrendador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/arrendadores/registro";
	}

	@PostMapping("save")
	public String save(@ModelAttribute("arrendador") Arrendador arrendador, SessionStatus status) {
		try {
			arrendadorService.save(arrendador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping 
		return "redirect:/arrendadores";
	}
	
	@PostMapping("cancel")
	public String cancel() {
		
		return "redirect:/login";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		try {
			Optional<Arrendador> optional = arrendadorService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("arrendador", optional.get());
				return "arrendadores/view";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/arrendadores";
	}
	
}
