package com.trabalho_pratico_grpo5.back;

import com.trabalho_pratico_grpo5.back.exception.CapacidadeExcedidaException;
import com.trabalho_pratico_grpo5.back.model.QuartoDuplo;
import com.trabalho_pratico_grpo5.back.model.QuartoFamilia;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
public class QuartoHospedesTest {
 
    // ───── QuartoDuplo (limite: 2) ─────
 
    @Test
    public void testDuploAceitaAteDoísHospedes() {
        QuartoDuplo quarto = new QuartoDuplo();
 
        assertDoesNotThrow(() -> quarto.setQuantidadeHospedes(2));
        assertEquals(2, quarto.getQuantidadeHospedes());
    }
 
    @Test
    public void testDuploRejeítaTresHospedes() {
        QuartoDuplo quarto = new QuartoDuplo();
 
        assertThrows(CapacidadeExcedidaException.class, () -> {
            quarto.setQuantidadeHospedes(3);
        });
    }
 
    @Test
    public void testDuploAceitaUmHospede() {
        QuartoDuplo quarto = new QuartoDuplo();
 
        assertDoesNotThrow(() -> quarto.setQuantidadeHospedes(1));
        assertEquals(1, quarto.getQuantidadeHospedes());
    }
 
    // ───── QuartoFamilia (limite: 10) ─────
 
    @Test
    public void testFamiliaAceitaAteDezHospedes() {
        QuartoFamilia quarto = new QuartoFamilia();
 
        assertDoesNotThrow(() -> quarto.setQuantidadeHospedes(10));
        assertEquals(10, quarto.getQuantidadeHospedes());
    }
 
    @Test
    public void testFamiliaRejeítaOnzeHospedes() {
        QuartoFamilia quarto = new QuartoFamilia();
 
        assertThrows(CapacidadeExcedidaException.class, () -> {
            quarto.setQuantidadeHospedes(11);
        });
    }
 
    @Test
    public void testFamiliaAceitaCincoHospedes() {
        QuartoFamilia quarto = new QuartoFamilia();
 
        assertDoesNotThrow(() -> quarto.setQuantidadeHospedes(5));
        assertEquals(5, quarto.getQuantidadeHospedes());
    }
 
    @Test
    public void testMensagemExcecaoDuplo() {
        QuartoDuplo quarto = new QuartoDuplo();
 
        CapacidadeExcedidaException ex = assertThrows(CapacidadeExcedidaException.class, () -> {
            quarto.setQuantidadeHospedes(5);
        });
 
        assertTrue(ex.getMessage().contains("2"));
    }
 
    @Test
    public void testMensagemExcecaoFamilia() {
        QuartoFamilia quarto = new QuartoFamilia();
 
        CapacidadeExcedidaException ex = assertThrows(CapacidadeExcedidaException.class, () -> {
            quarto.setQuantidadeHospedes(15);
        });
 
        assertTrue(ex.getMessage().contains("10"));
    }
}