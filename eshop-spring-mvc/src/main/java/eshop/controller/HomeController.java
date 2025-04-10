package eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String defaut() {
		return "redirect:accueil";
	}

	@GetMapping("/forward")
	public String forward() {
		return "forward:/accueil";
	}

	@RequestMapping(path = "/accueil", method = { RequestMethod.GET, RequestMethod.POST })
//	@GetMapping("/accueil")
	public String home(@RequestParam String nom, @RequestParam(required = false) String prenom,
			@RequestParam(required = false, defaultValue = "0") int age, Model model) {

		model.addAttribute("nom", nom);
		model.addAttribute("prenom", prenom);
		model.addAttribute("age", age);

		return "index";
	}

}
