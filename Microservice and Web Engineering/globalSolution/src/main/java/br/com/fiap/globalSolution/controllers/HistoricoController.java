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

import br.com.fiap.globalSolution.models.Drone;
import br.com.fiap.globalSolution.models.Historico;
import br.com.fiap.globalSolution.repositories.DroneRepository;
import br.com.fiap.globalSolution.repositories.HistoricoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/historico")
public class HistoricoController {

	@Autowired
	private HistoricoRepository historicoRepository;
	
	@Autowired
	private DroneRepository droneRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("historico/index");
		
		List<Historico> listHistorico = historicoRepository.findAll();
		
		model.addObject("historicos", listHistorico);
		return model;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long idHistorico) {
		Optional<Historico> selecionado = historicoRepository.findById(idHistorico);
		if(selecionado.isPresent()) {
			Historico historico = selecionado.get();
			model.addAttribute("historico", historico);
			return "historico/edit";
		} else {
			return "redirect:/historico";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("historico") Historico objHistorico, Model model) {
		Historico historico = historicoRepository.findById(id).orElse(null);
		
		historico.setIdDrone(objHistorico.getIdDrone());
		historico.setLatitudeInicio(objHistorico.getLatitudeInicio());
		historico.setLatitudeFim(objHistorico.getLatitudeFim());
		historico.setLongitudeInicio(objHistorico.getLongitudeInicio());
		historico.setLongitudeFim(objHistorico.getLongitudeFim());
		historico.setAltitude(objHistorico.getAltitude());
		historico.setDataAterrisagem(objHistorico.getDataAterrisagem());
		historico.setDataDecolagem(objHistorico.getDataDecolagem());
		historico.setVelocidade(objHistorico.getVelocidade());
		
		historicoRepository.save(historico);
		
		model.addAttribute("historico", historico);
		
		return "redirect:/";
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView model = new ModelAndView("historico/create");
		List<Drone> drones = droneRepository.findAll();
		
		model.addObject("drones", drones);
		return model;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Historico> create(@Valid @RequestBody Historico historico) {
		historicoRepository.save(historico);
		return new ResponseEntity<Historico>(historico, HttpStatus.CREATED);
	}
}
