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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.globalSolution.models.Drone;
import br.com.fiap.globalSolution.models.Licenca;
import br.com.fiap.globalSolution.repositories.DroneRepository;
import br.com.fiap.globalSolution.repositories.LicencaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/drone")
public class DroneController {
	
	@Autowired
	private DroneRepository droneRepository;
	
	@Autowired
	private LicencaRepository licencaRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("drone/index");
		
		List<Drone> listaDrone = droneRepository.findAll();
		
		model.addObject("drones", listaDrone);
		return model;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long idDrone) {
		Optional<Drone> selecionado = droneRepository.findById(idDrone);
		if(selecionado.isPresent()) {
			Drone drone = selecionado.get();
			model.addAttribute("drone", drone);
			return "drone/edit";
		} else {
			return "redirect:/drone";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("drone") Drone objDrone, Model model) {
		Drone drone = droneRepository.findById(id).orElse(null);
		
		drone.setModelo(objDrone.getModelo());
		drone.setDataCompra(objDrone.getDataCompra());
		drone.setCapacidadeCarga(objDrone.getCapacidadeCarga());
		drone.setNumeroSerie(objDrone.getNumeroSerie());
		drone.setIdLicenca(objDrone.getIdLicenca());
		drone.setCapacidadeBateria(objDrone.getCapacidadeBateria());
		
		droneRepository.save(drone);
		
		model.addAttribute("drone", drone);
		
		return "redirect:/";
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView model = new ModelAndView("drone/create");
		List<Licenca> licencas = licencaRepository.findAll();
		
		model.addObject("licencas", licencas);
		return model;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Drone> create(@Valid @RequestBody Drone drone) {
		droneRepository.save(drone);
		return new ResponseEntity<Drone>(drone, HttpStatus.CREATED);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		droneRepository.deleteById(id);
		return "redirect:/drone";
	}
}
