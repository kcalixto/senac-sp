package ex01.state;

import ex01.client.Jogador;
import ex01.client.JogadorMortoException;

public class Esperar implements Estado {
    private String msg = "Esperando";
    private Jogador jogador;

    public Esperar(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public void correr() throws JogadorMortoException {
        jogador.setEstado(new Correr(jogador));
    }

    @Override
    public void esperar() throws JogadorMortoException {
        jogador.setEstado(new Esperar(jogador));
    }

    @Override
    public void pular() throws JogadorMortoException {
        jogador.setEstado(new Pular(jogador));
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
