package pe.edu.upc.studenthome.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping ("registro") //va en la url
	public String registro() {
		return "/arrendadores/registro"; //html
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
	
	@GetMapping ("/modificar/{id}")
	public String modificar (@PathVariable long id, Model model) {
		try {
			Optional<Arrendador> arrendador=arrendadorService.findById(id);
			System.out.println("tag" + arrendador.get().getPersona().getNombrePersona());
			List<Distrito> distritos = distritoServices.findAll();
			model.addAttribute("distritos", distritos);
			model.addAttribute("arrendador", arrendador.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return "/arrendadores/modificar";
	}
	
	//@RequestMapping("/modificar/{id}")
	//public String (@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		//model.addAttribute("arrendador", arrendador);
		//return "";
		
	//}
	
	
	//@RequestMapping("/modificar/{id}")
	//public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		//Optional<Receta> objReceta = rService.listarId(id);
	//if (objReceta == null) {
	//	objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
	//	return "redirect:/recetas/listar";
	//} else {
	//	model.addAttribute("listaUsuarios", uService.listar());
	//	model.addAttribute("listaCategorias", cService.listar());
	//	if (objReceta.isPresent())
	//	objReceta.ifPresent(o -> model.addAttribute("receta", o));
				//	return "/usuario/recetas";
	//}
	//}
	
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
