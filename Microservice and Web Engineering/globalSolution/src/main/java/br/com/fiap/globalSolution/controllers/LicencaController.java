package br.com.fiap.globalSolution.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.globalSolution.models.Licenca;
import br.com.fiap.globalSolution.repositories.DroneRepository;
import br.com.fiap.globalSolution.repositories.LicencaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/licenca")
public class LicencaController {
	
	@Autowired
	private LicencaRepository licencaRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("licenca/index");
		
		List<Licenca> listLicenca = licencaRepository.findAll();
		
		model.addObject("licencas", listLicenca);
		return model;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long idLicenca) {
		Optional<Licenca> selecionado = licencaRepository.findById(idLicenca);
		if(selecionado.isPresent()) {
			Licenca licenca = selecionado.get();
			model.addAttribute("licenca", licenca);
			return "licenca/edit";
		} else {
			return "redirect:/licenca";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("licenca") Licenca objLicenca, Model model) {
		Licenca licenca = licencaRepository.findById(id).orElse(null);
		
		licenca.setLicenca(objLicenca.getLicenca());
		licenca.setDataValidade(objLicenca.getDataValidade());
		licenca.setDataEmissao(objLicenca.getDataEmissao());
		
		licencaRepository.save(licenca);
		
		model.addAttribute("licenca", licenca);
		
		return "redirect:/";
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView model = new ModelAndView("licenca/create");
		return model;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Licenca> create(@Valid @RequestBody Licenca licenca) {
		licencaRepository.save(licenca);
		return new ResponseEntity<Licenca>(licenca, HttpStatus.CREATED);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		licencaRepository.deleteById(id);
		return "redirect:/licenca";
	}
}
