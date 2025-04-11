package eshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import eshop.dao.IDAOProduit;
import eshop.model.Produit;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	
	
	private IDAOProduit daoProduit;

	public ProduitController(IDAOProduit daoProduit) {
		super();
		this.daoProduit = daoProduit;
	}
	
	@GetMapping({"", "/", "/list"}) // ETAPE 1 : Réception de la Request
	public String list(Model model) {
		// ETAPE 2 : Récupération des données
		List<Produit> produits = daoProduit.findAll();
		
		//ETAPE 3 : Renseigne le Model
		model.addAttribute("mesProduits", produits);
		
		// ETAPE 4 : Appel de la View
		return "produit/list";
	}
	
	@GetMapping("/add") 
	public String add(Model model) {
		model.addAttribute("produit", new Produit());		
		
		return "produit/form";
	}
	
	@GetMapping("/edit") // Récupérer l'id, rechercher le produit et le renvoyer à la page de formulaire
	public String edit(@RequestParam Integer id, Model model) {
		Produit produit = daoProduit.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé"));
	
		
//		Optional<Produit> optProduit = daoProduit.findById(id);
//		
//		if(optProduit.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé");
//		}
//		
//		Produit produit = optProduit.get();
		
		model.addAttribute("produit", produit);
		
		return "produit/form";
	}
	
	@GetMapping("/remove") // Récupérer l'id, supprimer le produit et rafficher la liste mise à jour avec une redirection
	public String remove(@RequestParam Integer id) {
		if(!daoProduit.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé");
		}
		
		daoProduit.deleteById(id);
		
		return "redirect:list";
	}
	
//	@RequestMapping(path = "/save", method = { RequestMethod.POST })
	@PostMapping("/save") // Récupérer les données du formulaire dans Produit, de sauvegarder le Produit en BDD et de rafraichir la liste 
	public String save(@ModelAttribute @Valid Produit produit, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "produit/form";
		}
		
		daoProduit.save(produit);
		
		return "redirect:list";
	}
	
	@GetMapping("/cancel") // Forward vers le controlleur list
	public String cancel() {
		
		return "forward:list";
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
