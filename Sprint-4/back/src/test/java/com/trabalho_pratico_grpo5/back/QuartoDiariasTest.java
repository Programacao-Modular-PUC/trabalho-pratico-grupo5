package com.trabalho_pratico_grpo5.back;

import com.trabalho_pratico_grpo5.back.model.QuartoIndividual;
import com.trabalho_pratico_grpo5.back.model.QuartoDuplo;
import com.trabalho_pratico_grpo5.back.model.QuartoFamilia;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
public class QuartoDiariasTest {
 
    // ───── QuartoIndividual ─────
 
    @Test
    public void testDiariaIndividualUmaCama() {
        QuartoIndividual quarto = new QuartoIndividual();
        quarto.setValorDiariaBase(100.0);
        quarto.setQuantidadeCamasSolteiro(1);
 
        assertEquals(100.0, quarto.verificarPrecoFinal());
    }
 
    @Test
    public void testDiariaIndividualDuasCamas() {
        QuartoIndividual quarto = new QuartoIndividual();
        quarto.setValorDiariaBase(100.0);
        quarto.setQuantidadeCamasSolteiro(2);
 
        // base + (2-1) * 50 = 150
        assertEquals(150.0, quarto.verificarPrecoFinal());
    }
 
    @Test
    public void testDiariaIndividualTresCamas() {
        QuartoIndividual quarto = new QuartoIndividual();
        quarto.setValorDiariaBase(100.0);
        quarto.setQuantidadeCamasSolteiro(3);
 
        // base + (3-1) * 50 = 200
        assertEquals(200.0, quarto.verificarPrecoFinal());
    }
 
    // ───── QuartoDuplo ─────
 
    @Test
    public void testDiariaDuploCamaSolteiro() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorDiariaBase(150.0);
        quarto.setTipoCama("solteiro");
 
        assertEquals(150.0, quarto.verificarPrecoFinal());
    }
 
    @Test
    public void testDiariaDuploCamaQueen() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorDiariaBase(150.0);
        quarto.setTipoCama("queen");
 
        // base + 80 = 230
        assertEquals(230.0, quarto.verificarPrecoFinal());
    }
 
    @Test
    public void testDiariaDuploCamaKing() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorDiariaBase(150.0);
        quarto.setTipoCama("king");
 
        // base + 120 = 270
        assertEquals(270.0, quarto.verificarPrecoFinal());
    }
 
    @Test
    public void testDiariaDuploComBerco() {
        QuartoDuplo quarto = new QuartoDuplo();
        quarto.setValorDiariaBase(150.0);
        quarto.setTipoCama("queen");
        quarto.setPossuiBerco(true);
 
        // base + 80 (queen) + 40 (berco) = 270
        assertEquals(270.0, quarto.verificarPrecoFinal());
    }
 
    // ───── QuartoFamilia ─────
 
    @Test
    public void testDiariaFamiliaQuatroHospedes() {
        QuartoFamilia quarto = new QuartoFamilia();
        quarto.setValorDiariaBase(200.0);
        quarto.setQuantidadeHospedes(4);
 
        // base + 4*70 = 480 (sem desconto)
        assertEquals(480.0, quarto.verificarPrecoFinal());
    }
 
    @Test
    public void testDiariaFamiliaComDescontoCincoHospedes() {
        QuartoFamilia quarto = new QuartoFamilia();
        quarto.setValorDiariaBase(200.0);
        quarto.setQuantidadeHospedes(5);
 
        // (base + 5*70) * 0.90 = (200+350)*0.90 = 495
        assertEquals(495.0, quarto.verificarPrecoFinal());
    }
}