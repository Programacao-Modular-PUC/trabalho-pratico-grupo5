package com.trabalho_pratico_grpo5.back.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected double valorDiariaBase;

    protected boolean possuiAC;

    protected boolean possuiHidro;

    protected boolean disponivel = true;
    
    public abstract double verificarPrecoFinal();

    public Long getId() {
        return id;
    }

    public double getValorDiariaBase() {
        return valorDiariaBase;
    }

    public void setValorDiariaBase(double valorDiariaBase) {
        this.valorDiariaBase = valorDiariaBase;
    }

    public boolean isPossuiAC() {
        return possuiAC;
    }

    public void setPossuiAC(boolean possuiAC) {
        this.possuiAC = possuiAC;
    }

    public boolean isPossuiHidro() {
        return possuiHidro;
    }

    public void setPossuiHidro(boolean possuiHidro) {
        this.possuiHidro = possuiHidro;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
 
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}