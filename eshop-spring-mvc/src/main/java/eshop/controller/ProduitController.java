package eshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import eshop.dao.IDAOProduit;
import eshop.model.Produit;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	
	
	private IDAOProduit daoProduit;

	public ProduitController(IDAOProduit daoProduit) {
		super();
		this.daoProduit = daoProduit;
	}
	
	@GetMapping("/list") // ETAPE 1 : Réception de la Request
	public String list(Model model) {
		// ETAPE 2 : Récupération des données
		List<Produit> produits = daoProduit.findAll();
		
		//ETAPE 3 : Renseigne le Model
		model.addAttribute("mesProduits", produits);
		
		// ETAPE 4 : Appel de la View
		return "produit/list";
	}
	
	@GetMapping("/add") // Renvoyer vers la page de formulaire avec Produit vierge
	public String add() {
		
		return "produit/form";
	}
	
	@GetMapping("/edit") // Récupérer l'id, rechercher le produit et le renvoyer à la page de formulaire
	public String edit() {
		
		return "produit/form";
	}
	
	@GetMapping("/remove") // Récupérer l'id, supprimer le produit et rafficher la liste mise à jour avec une redirection
	public String remove() {
		
		return "";
	}
	
//	@RequestMapping(path = "/save", method = { RequestMethod.POST })
	@PostMapping("/save") // Récupérer les données du formulaire dans Produit, de sauvegarder le Produit en BDD et de rafraichir la liste 
	public String save(@ModelAttribute Produit produit, Model model) {
		
		
		return "produit";
	}
	
	@GetMapping("/cancel") // Forward vers le controlleur list
	public String cancel() {
		
		return "";
	}

//	@RequestMapping(path = "/produit", method = { RequestMethod.GET, RequestMethod.POST })
//	public String edit(@RequestParam(required = false) Integer id, @RequestParam(required = false) String libelle,
//			@RequestParam(required = false, defaultValue = "0.0") double prix, Model model) {
//		
//		// Créer un objet Produit à partir des données en paramètres
//		// Renvoyer cet objet vers la page produit
//		// Et modifier la page produit pour la refaire fonctionner
//
//		model.addAttribute("id", id);
//		model.addAttribute("libelle", libelle);
//		model.addAttribute("prix", prix);
//
//		return "produit";
//	}
	


	



	

}
