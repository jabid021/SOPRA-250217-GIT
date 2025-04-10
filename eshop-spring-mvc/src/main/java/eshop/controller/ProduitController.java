package eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {

	@RequestMapping(path = "/produit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(@RequestParam(required = false) Integer id, @RequestParam(required = false) String libelle,
			@RequestParam(required = false, defaultValue = "0.0") double prix, Model model) {

		model.addAttribute("id", id);
		model.addAttribute("libelle", libelle);
		model.addAttribute("prix", prix);

		return "produit";
	}

}
