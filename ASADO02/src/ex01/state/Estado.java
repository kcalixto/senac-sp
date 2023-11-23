package ex01.state;

import ex01.client.JogadorMortoException;

public interface Estado {
    public void correr() throws JogadorMortoException;

    public void esperar() throws JogadorMortoException;

    public void pular() throws JogadorMortoException;

    public String getMsg();
}
