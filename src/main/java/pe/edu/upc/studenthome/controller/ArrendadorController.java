package pe.edu.upc.studenthome.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.upc.studenthome.models.entities.Arrendador;
import pe.edu.upc.studenthome.models.entities.Distrito;
import pe.edu.upc.studenthome.models.entities.Habitacion;
import pe.edu.upc.studenthome.service.ArrendadorServices;
import pe.edu.upc.studenthome.service.DistritoService;
import pe.edu.upc.studenthome.service.HabitacionService;

@Controller
@RequestMapping("/arrendadores")
@SessionAttributes("arrendador")
public class ArrendadorController {
	
	@Autowired
	private ArrendadorServices arrendadorService;
	
	@Autowired
	private DistritoService distritoServices;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@GetMapping ("/registro")
	public String registro(Model model) {
		Arrendador arrendador = new Arrendador();
		Habitacion habitacion = new Habitacion();
		
		try {
			List<Arrendador> arrendadores = arrendadorService.findAll();
			List<Distrito> distritos = distritoServices.findAll();
			List<Habitacion>habitaciones = habitacionService.findAll();
			model.addAttribute("arrendadores", arrendadores);
			model.addAttribute("distritos", distritos);
			model.addAttribute("arrendador", arrendador);
			model.addAttribute("habitacion", habitacion);
			model.addAttribute("habitaciones", habitaciones);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/arrendadores/registro";
		
		
		
	}
	
	@GetMapping
	public String inicio(Model model) {
		Arrendador arrendador = new Arrendador();
		Habitacion habitacion = new Habitacion();
		
		try {
			List<Arrendador> arrendadores = arrendadorService.findAll();
			List<Distrito> distritos = distritoServices.findAll();
			List<Habitacion>habitaciones = habitacionService.findAll();
			model.addAttribute("arrendadores", arrendadores);
			model.addAttribute("distritos", distritos);
			model.addAttribute("arrendador", arrendador);
			model.addAttribute("habitacion", habitacion);
			model.addAttribute("habitaciones", habitaciones);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/arrendadores/perfilarrendador";
		
		
		
	}
	
	@GetMapping ("sobrenosotros") //va en la url
	public String sobrenostros() {
		return "/arrendadores/sobrenosotros"; //html
	}
	
	

	@PostMapping("save")
	public String save( Arrendador arrendador, SessionStatus status) { 
		try {
			arrendadorService.save(arrendador); //solo dejar esto
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
	
	//el controller es el nexo entre las funcionesen el html y la bd
	@GetMapping ("/modificar/{id}")// getmapping para mostrar una pag web + return. Get mapping url - return html
	public String modificar ( @PathVariable long id, Model model) { //pathvariable valor que esta en la url va a ser asignado a la variable id
		try {
			Optional<Arrendador>arrendador=arrendadorService.findById(id); //busca en la bd a que arrendador le pertenece el id
			System.out.println("tag" + arrendador.get().getPersona().getNombrePersona()); //anexo de depuracion borrar luego
			List<Distrito> distritos = distritoServices.findAll();//brinda todos los distritos
			model.addAttribute("distritos", distritos);
			model.addAttribute("arrendador", arrendador.get()); //azul es el nombre del obj que enviamos al html, el que hace el envio es el model
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/arrendadores/modificar"; //a que html me dirige
	}
	

	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		try {
			Optional<Arrendador> optional = arrendadorService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("arrendador", optional.get());
				return "/arrendadores/registro";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/arrendadores";
	}
	
}
