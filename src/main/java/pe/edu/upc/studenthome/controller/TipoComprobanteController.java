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
import pe.edu.upc.studenthome.models.entities.TipoComprobante;
import pe.edu.upc.studenthome.service.TipoComprobanteService;

@Controller
@RequestMapping("/comprobantes")
@SessionAttributes("tipocomprobante")
public class TipoComprobanteController {
	
	@Autowired
	private TipoComprobanteService tipoComprobanteService;
	
	@GetMapping
	public String registro(Model model) {
		TipoComprobante tipocomprobante=new TipoComprobante();
		try {
			List<TipoComprobante> tipocomprobantes = tipoComprobanteService.findAll();
		    model.addAttribute("tipocomprobantes", tipocomprobantes);
			model.addAttribute("tipocomprobante", tipocomprobante); 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.out.println();
		}
		return "/comprobantes/registrocomprobantes";
	}
	
	@PostMapping("save") 
	public String save(@ModelAttribute("tipocomprobante") TipoComprobante tipocomprobante, SessionStatus status) { 
		try {
			tipoComprobanteService.save(tipocomprobante);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/comprobantes";
	}
}
