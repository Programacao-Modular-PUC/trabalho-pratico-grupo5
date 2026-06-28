package com.trabalho_pratico_grpo5.back.notification;

public class NotificacaoSMS implements Notificavel {
 
    @Override
    public void notificar(String evento, String mensagem) {
        System.out.println("[SMS] Evento: " + evento + " | Mensagem: " + mensagem);
    }
}
