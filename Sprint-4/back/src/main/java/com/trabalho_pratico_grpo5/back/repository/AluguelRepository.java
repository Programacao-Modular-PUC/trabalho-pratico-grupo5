package com.trabalho_pratico_grpo5.back.repository;

import com.trabalho_pratico_grpo5.back.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    List<Aluguel> findByClienteId(Long clienteId);

}
