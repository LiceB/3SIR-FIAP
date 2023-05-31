package br.com.fiap.globalSolution.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalSolution.models.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

}
