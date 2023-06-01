package br.com.fiap.globalSolution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.globalSolution.models.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {

}
