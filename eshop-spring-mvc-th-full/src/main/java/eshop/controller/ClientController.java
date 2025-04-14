package eshop.controller;

import java.time.LocalDate;
import java.time.Period;
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

import eshop.dao.IDAOPersonne;
import eshop.model.Adresse;
import eshop.model.Client;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {

	private IDAOPersonne daoPersonne;

	public ClientController(IDAOPersonne daoPersonne) {
		super();
		this.daoPersonne = daoPersonne;
	}

	@GetMapping({ "", "/", "/list" }) 
	public String list(Model model) {
		List<Client> clients = daoPersonne.findAllClient();

		model.addAttribute("clients", clients);

		return "client/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		Client client = new Client();
		client.setAdresse(new Adresse());
		
		model.addAttribute("client", client);

		return "client/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Client client = daoPersonne.findClientByIdWithAchats(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client non trouvé"));

		if(client.getAdresse() == null) {
			client.setAdresse(new Adresse());
		}
		
		model.addAttribute("client", client);

		return "client/form";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam Integer id) {
		if (!daoPersonne.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client non trouvé");
		}

		daoPersonne.deleteById(id);

		return "redirect:list";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute @Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client/form";
		}
		
		int age = Period.between(client.getDateNaissance(), LocalDate.now()).getYears();
		
		client.setAge(age);

		daoPersonne.save(client);

		return "redirect:list";
	}

	@GetMapping("/cancel")
	public String cancel() {

		return "forward:list";
	}

}
