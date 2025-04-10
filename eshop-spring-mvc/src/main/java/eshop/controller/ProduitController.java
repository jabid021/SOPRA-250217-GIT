package eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.dao.IDAOProduit;

@Controller
public class ProduitController {
	
	@Autowired
	private IDAOProduit daoProduit;

	@RequestMapping(path = "/produit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(@RequestParam(required = false) Integer id, @RequestParam(required = false) String libelle,
			@RequestParam(required = false, defaultValue = "0.0") double prix, Model model) {
		
		// Créer un objet Produit à partir des données en paramètres
		// Renvoyer cet objet vers la page produit
		// Et modifier la page produit pour la refaire fonctionner

		model.addAttribute("id", id);
		model.addAttribute("libelle", libelle);
		model.addAttribute("prix", prix);

		return "produit";
	}

}
