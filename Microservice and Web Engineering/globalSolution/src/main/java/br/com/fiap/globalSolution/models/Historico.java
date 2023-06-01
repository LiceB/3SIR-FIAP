package br.com.fiap.globalSolution.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "O drone é obrigatório")
	@Min(value = 1, message = "Favor selecionar o drone")
	private Long idDrone;

	@NotNull
	@NotBlank
	private String latitudeInicio;

	@NotNull
	@NotBlank
	private String latitudeFim;

	@NotNull
	@NotBlank
	private String longitudeInicio;

	@NotNull
	@NotBlank
	private String longitudeFim;

	@NotNull
	@NotBlank
	private String altitude;

	private LocalDate dataAterrisagem;
	private LocalDate dataDecolagem;

	@NotNull
	@NotBlank
	private String velocidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(Long idDrone) {
		this.idDrone = idDrone;
	}

	public String getLatitudeInicio() {
		return latitudeInicio;
	}

	public void setLatitudeInicio(String latitudeInicio) {
		this.latitudeInicio = latitudeInicio;
	}

	public String getLatitudeFim() {
		return latitudeFim;
	}

	public void setLatitudeFim(String latitudeFim) {
		this.latitudeFim = latitudeFim;
	}

	public String getLongitudeInicio() {
		return longitudeInicio;
	}

	public void setLongitudeInicio(String longitudeInicio) {
		this.longitudeInicio = longitudeInicio;
	}

	public String getLongitudeFim() {
		return longitudeFim;
	}

	public void setLongitudeFim(String longitudeFim) {
		this.longitudeFim = longitudeFim;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public LocalDate getDataAterrisagem() {
		return dataAterrisagem;
	}

	public void setDataAterrisagem(LocalDate dataAterrisagem) {
		this.dataAterrisagem = dataAterrisagem;
	}

	public LocalDate getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(LocalDate dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public String getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}

}
