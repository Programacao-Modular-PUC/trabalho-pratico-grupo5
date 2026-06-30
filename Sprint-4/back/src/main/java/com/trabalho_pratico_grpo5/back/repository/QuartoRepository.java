package com.trabalho_pratico_grpo5.back.repository;

import com.trabalho_pratico_grpo5.back.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    List<Quarto> findByDisponivel(boolean disponivel);
}