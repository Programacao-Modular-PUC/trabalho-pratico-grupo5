package com.trabalho_pratico_grpo5.back.exception;

public class RecursoNaoPermitidoException extends RuntimeException {
 
    public RecursoNaoPermitidoException(String mensagem) {
        super(mensagem);
    }
}