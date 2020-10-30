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

import pe.edu.upc.studenthome.models.entities.TipoInmueble;
import pe.edu.upc.studenthome.service.TipoInmuebleService;

@Controller
@RequestMapping("/tipoinmuebles")
public class TipoInmuebleController {
	
	@Autowired
	private TipoInmuebleService tipoInmuebleService;
	
	@GetMapping
	public String inicio(Model model) {
		TipoInmueble tipoinmueble = new TipoInmueble();
		
		try {
			//List<TipoInmueble> tipoinmueble = tipoinmuebleService.findAll();
			//model.addAttribute("tipoinmuebles", tipoinmuebles);
			model.addAttribute("tipoinmueble", tipoinmueble);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/tipoinmuebles/registro";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("tipoinmueble") TipoInmueble tipoinmueble, SessionStatus status) {
		try {
			tipoInmuebleService.save(tipoinmueble);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping 
		return "redirect:/tipoinmuebles";
	}
	
}