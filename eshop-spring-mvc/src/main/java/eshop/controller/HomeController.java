package eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

//	@RequestMapping(path = "/accueil", method = RequestMethod.GET)
	@GetMapping("/accueil")
	public String home(@RequestParam String nom, @RequestParam(required = false) String prenom, @RequestParam(required = false, defaultValue = "0") int age) {

		System.out.println("nom=" + nom);
		System.out.println("prenom=" + prenom);
		System.out.println("age=" + age);

		return "index";
	}

}
