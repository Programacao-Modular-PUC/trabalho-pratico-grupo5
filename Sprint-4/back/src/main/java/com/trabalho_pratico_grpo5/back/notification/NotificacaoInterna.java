package com.trabalho_pratico_grpo5.back.notification;

public class NotificacaoInterna implements Notificavel {
 
    @Override
    public void notificar(String evento, String mensagem) {
        System.out.println("[INTERNO] Evento: " + evento + " | Mensagem: " + mensagem);
    }
}
