package com.trabalho_pratico_grpo5.back;

import com.trabalho_pratico_grpo5.back.exception.DataInvalidaException;
import com.trabalho_pratico_grpo5.back.model.Aluguel;
import com.trabalho_pratico_grpo5.back.model.QuartoIndividual;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
 
public class AluguelDisponibilidadeTest {
 
    // ───── Disponibilidade do quarto ─────
 
    @Test
    public void testQuartoDisponivelPorPadrao() {
        QuartoIndividual quarto = new QuartoIndividual();
 
        assertTrue(quarto.isDisponivel());
    }
 
    @Test
    public void testQuartoFicaIndisponivelAposReserva() {
        QuartoIndividual quarto = new QuartoIndividual();
        quarto.setDisponivel(false);
 
        assertFalse(quarto.isDisponivel());
    }
 
    @Test
    public void testQuartoFicaDisponivelAposCancelamento() {
        QuartoIndividual quarto = new QuartoIndividual();
        quarto.setDisponivel(false);
 
        Aluguel aluguel = new Aluguel();
        aluguel.setQuarto(quarto);
        aluguel.cancelar();
 
        assertTrue(quarto.isDisponivel());
    }
 
    // ───── Validação de datas ─────
 
    @Test
    public void testDataInicioNulaLancaExcecao() {
        Aluguel aluguel = new Aluguel();
 
        assertThrows(DataInvalidaException.class, () -> {
            aluguel.setDataInicio(null);
        });
    }
 
    @Test
    public void testDataFimNulaLancaExcecao() {
        Aluguel aluguel = new Aluguel();
 
        assertThrows(DataInvalidaException.class, () -> {
            aluguel.setDataFim(null);
        });
    }
 
    @Test
    public void testDataFimAntesDeDataInicioLancaExcecao() {
        Aluguel aluguel = new Aluguel();
        aluguel.setDataInicio(LocalDate.of(2025, 6, 10));
 
        assertThrows(DataInvalidaException.class, () -> {
            aluguel.setDataFim(LocalDate.of(2025, 6, 5));
        });
    }
 
    @Test
    public void testDatasValidasNaoLancamExcecao() {
        Aluguel aluguel = new Aluguel();
 
        assertDoesNotThrow(() -> {
            aluguel.setDataInicio(LocalDate.of(2025, 6, 10));
            aluguel.setDataFim(LocalDate.of(2025, 6, 15));
        });
    }
 
    @Test
    public void testCancelamentoDeAluguelJaCanceladoLancaExcecao() {
        Aluguel aluguel = new Aluguel();
        aluguel.cancelar();
 
        assertThrows(IllegalStateException.class, () -> {
            aluguel.cancelar();
        });
    }
}
