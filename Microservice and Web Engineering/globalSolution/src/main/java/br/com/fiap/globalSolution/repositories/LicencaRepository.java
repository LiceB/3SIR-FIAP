package br.com.fiap.globalSolution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalSolution.models.Licenca;

@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Long> {

}
