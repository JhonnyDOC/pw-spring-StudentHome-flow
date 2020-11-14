package pe.edu.upc.studenthome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("layout")
	public String layout() {
		return "layout/layout";
	}
}
