package eshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

import eshop.controller.dto.FournisseurDTO;
import eshop.dao.IDAOPersonne;
import eshop.model.Fournisseur;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	private IDAOPersonne daoPersonne;

	public FournisseurController(IDAOPersonne daoPersonne) {
		super();
		this.daoPersonne = daoPersonne;
	}

	@GetMapping({ "", "/", "/list" })
	public String list(Model model) {
		List<Fournisseur> fournisseurs = daoPersonne.findAllFournisseur();

		List<FournisseurDTO> fournisseursDTO = new ArrayList<>();

		for (Fournisseur fournisseur : fournisseurs) {
			FournisseurDTO fournisseurDTO = new FournisseurDTO();

			BeanUtils.copyProperties(fournisseur, fournisseursDTO);

			if (fournisseur.getAdresse() != null) {
				BeanUtils.copyProperties(fournisseur.getAdresse(), fournisseursDTO);

				fournisseurDTO.setRue(fournisseur.getAdresse().getNumero() + " " + fournisseur.getAdresse().getVoie());
				fournisseurDTO.setCodePostal(fournisseur.getAdresse().getCp());
			}
			
			fournisseursDTO.add(fournisseurDTO);
		}
		
		model.addAttribute("fournisseurs", fournisseursDTO);

		return "fournisseur/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		

		return "fournisseur/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		

		return "fournisseur/form";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam Integer id) {
		if (!daoPersonne.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fournisseur non trouvé");
		}

		daoPersonne.deleteById(id);

		return "redirect:list";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute @Valid FournisseurDTO fournisseurDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "fournisseur/form";
		}

		return "redirect:list";
	}

	@GetMapping("/cancel")
	public String cancel() {

		return "forward:list";
	}

}
