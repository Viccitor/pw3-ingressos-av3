package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository {

    List<Sala>findAllByDataExclusaoIsNull();

}
