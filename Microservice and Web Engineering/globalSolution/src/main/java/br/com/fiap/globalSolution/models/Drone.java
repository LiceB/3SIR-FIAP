package br.com.fiap.globalSolution.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Drone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@NotBlank
	private String modelo;

	private LocalDate dataCompra;
	
	@NotNull
	@NotBlank
	private String capacidadeCarga;
	
	@Pattern(regexp = "[0-9]{10}", message = "Número de série fora do padrão 9999999999")
	private String numeroSerie;
	
	@NotNull(message = "A licença é obrigatória")
	@Min(value = 1, message = "Favor selecionar a licença")
	private Long idLicenca;
	
	@NotNull
	@NotBlank
	private String capacidadeBateria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(String capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Long getIdLicenca() {
		return idLicenca;
	}

	public void setIdLicenca(Long idLicenca) {
		this.idLicenca = idLicenca;
	}

	public String getCapacidadeBateria() {
		return capacidadeBateria;
	}

	public void setCapacidadeBateria(String capacidadeBateria) {
		this.capacidadeBateria = capacidadeBateria;
	}

}
