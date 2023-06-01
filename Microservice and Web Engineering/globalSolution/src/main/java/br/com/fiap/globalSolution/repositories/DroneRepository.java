package br.com.fiap.globalSolution.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalSolution.models.Drone;
import br.com.fiap.globalSolution.models.Licenca;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

	@Query(value="select d.id, d.modelo, d.data_compra, d.capacidade_carga, d.numero_serie, d.id_licenca, l.licenca, d.capacidade_bateria "
			+ "from drone d join licenca l on d.id_licenca = l.id;", nativeQuery = true)
	List<Drone> findByIdLicenca(Long idLicenca);
}
