package com.trabalho_pratico_grpo5.back.notification;

import java.util.ArrayList;
import java.util.List;
 
public class GerenciadorDeNotificacoes {
 
    private static GerenciadorDeNotificacoes instancia;
 
    private final List<Notificavel> canais = new ArrayList<>();
 
    private GerenciadorDeNotificacoes() {
        // construtor privado - Singleton
    }
 
    public static GerenciadorDeNotificacoes getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorDeNotificacoes();
        }
        return instancia;
    }
 
    public void registrarCanal(Notificavel canal) {
        canais.add(canal);
    }
 
    public void removerCanal(Notificavel canal) {
        canais.remove(canal);
    }
 
    public void notificarTodos(String evento, String mensagem) {
        for (Notificavel canal : canais) {
            canal.notificar(evento, mensagem);
        }
    }
}
