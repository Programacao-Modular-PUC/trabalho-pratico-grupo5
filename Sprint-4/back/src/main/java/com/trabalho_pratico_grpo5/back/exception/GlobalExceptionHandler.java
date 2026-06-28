package com.trabalho_pratico_grpo5.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
@ControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(QuartoIndisponivelException.class)
    public ResponseEntity<String> handleQuartoIndisponivel(QuartoIndisponivelException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
 
    @ExceptionHandler(CapacidadeExcedidaException.class)
    public ResponseEntity<String> handleCapacidadeExcedida(CapacidadeExcedidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
 
    @ExceptionHandler(DataInvalidaException.class)
    public ResponseEntity<String> handleDataInvalida(DataInvalidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
 
    @ExceptionHandler(RecursoNaoPermitidoException.class)
    public ResponseEntity<String> handleRecursoNaoPermitido(RecursoNaoPermitidoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
 
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalState(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
 
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
 
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}