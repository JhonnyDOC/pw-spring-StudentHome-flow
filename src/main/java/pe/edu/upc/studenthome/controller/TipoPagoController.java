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

import pe.edu.upc.studenthome.models.entities.TipoPago;
import pe.edu.upc.studenthome.service.TipoPagoService;

@Controller
@RequestMapping("/pagos")
@SessionAttributes("tipopago")
public class TipoPagoController {

	@Autowired
	private TipoPagoService tipoPagoService;
	
	@GetMapping
	public String registro(Model model) {
		TipoPago tipopago=new TipoPago();
		try {
			List<TipoPago> tipopagos = tipoPagoService.findAll();
		    model.addAttribute("tipopagos", tipopagos);
			model.addAttribute("tipopago", tipopago); 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.out.println();
		}
		return "/pagos/registropagos";
	}
	
	@PostMapping("save") 
	public String save(@ModelAttribute("tipopago") TipoPago tipopago, SessionStatus status) { 
		try {
			tipoPagoService.save(tipopago);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/pagos";
	}
	
}
