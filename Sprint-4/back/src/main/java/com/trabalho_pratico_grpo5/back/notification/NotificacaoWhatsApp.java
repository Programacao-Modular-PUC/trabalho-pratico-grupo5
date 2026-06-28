package com.trabalho_pratico_grpo5.back.notification;

public class NotificacaoWhatsApp implements Notificavel {
 
    @Override
    public void notificar(String evento, String mensagem) {
        System.out.println("[WHATSAPP] Evento: " + evento + " | Mensagem: " + mensagem);
    }
}
