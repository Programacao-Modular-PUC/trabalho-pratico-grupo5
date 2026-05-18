package com.trabalho_pratico_grpo5.back.repository;

import com.trabalho_pratico_grpo5.back.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}