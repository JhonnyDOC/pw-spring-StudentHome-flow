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

import pe.edu.upc.studenthome.models.entities.Renta;
import pe.edu.upc.studenthome.service.RentaService;

@Controller
@RequestMapping("/rentas")
@SessionAttributes("renta")
public class RentaController {

	@Autowired
	private RentaService rentaService;
	
//obtener data de la bd y enviarlo al front
	@GetMapping
	//metodo que carga registrorentas
	public String registro(Model model) {
		Renta renta=new Renta();
		//renta.setDescripcionRenta("comodo"); prueba de que sí manda
		try {
			List<Renta> rentas = rentaService.findAll();
			model.addAttribute("rentas", rentas);
			model.addAttribute("renta", renta); //envio objeto al html, cuando esto se envia, regresa como objeto gracias al Session Attribute
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.out.println();
		}
		//devuelve el nombre del archivo html
		return "/rentas/registrorentas";
	}
	
	//rentas/save, el boton grabar envia al archivo action vinculado, el action hace que llegue al controller y del controller se imprime
	@PostMapping("save") //cuando se envie data a partir de un formulario se vuelve un post
	public String save(@ModelAttribute("renta") Renta renta, SessionStatus status) { //metodo que grabará los datos ingresados, el objeto viene del modelo. Siempre se usa el session status
		try {
			rentaService.save(renta);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//devuelve la url 
		return "redirect:/rentas";
	}
}
