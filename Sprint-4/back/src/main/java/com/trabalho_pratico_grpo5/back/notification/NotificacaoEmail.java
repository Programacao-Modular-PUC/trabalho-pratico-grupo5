package com.trabalho_pratico_grpo5.back.notification;

public class NotificacaoEmail implements Notificavel {
 
    @Override
    public void notificar(String evento, String mensagem) {
        System.out.println("[EMAIL] Evento: " + evento + " | Mensagem: " + mensagem);
    }
}