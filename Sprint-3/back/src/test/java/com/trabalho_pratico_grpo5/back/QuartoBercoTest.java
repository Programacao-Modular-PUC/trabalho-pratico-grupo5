package com.trabalho_pratico_grpo5.back;

import com.trabalho_pratico_grpo5.back.exception.RecursoNaoPermitidoException;
import com.trabalho_pratico_grpo5.back.model.QuartoIndividual;
import com.trabalho_pratico_grpo5.back.model.QuartoDuplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
public class QuartoBercoTest {
 
    @Test
    public void testBercoNaoPermitidoEmQuartoIndividual() {
        QuartoIndividual quarto = new QuartoIndividual();
 
        assertThrows(RecursoNaoPermitidoException.class, () -> {
            quarto.setPossuiBerco(true);
        });
    }
 
    @Test
    public void testSemBercoEmQuartoIndividualPermitido() {
        QuartoIndividual quarto = new QuartoIndividual();
 
        assertDoesNotThrow(() -> {
            quarto.setPossuiBerco(false);
        });
 
        assertFalse(quarto.isPossuiBerco());
    }
 
    @Test
    public void testBercoPermitidoEmQuartoDuplo() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorDiariaBase(150.0);
        quarto.setTipoCama("solteiro");
 
        assertDoesNotThrow(() -> {
            quarto.setPossuiBerco(true);
        });
 
        assertTrue(quarto.isPossuiBerco());
    }
 
    @Test
    public void testSemBercoEmQuartoDuplo() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setPossuiBerco(false);
 
        assertFalse(quarto.isPossuiBerco());
    }
 
    @Test
    public void testMensagemExcecaoBercoIndividual() {
        QuartoIndividual quarto = new QuartoIndividual();
 
        RecursoNaoPermitidoException ex = assertThrows(RecursoNaoPermitidoException.class, () -> {
            quarto.setPossuiBerco(true);
        });
 
        assertEquals("Berço não é permitido em quarto individual.", ex.getMessage());
    }
}
