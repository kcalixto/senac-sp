package ex01.client;

import ex01.state.Correr;
import ex01.state.Esperar;
import ex01.state.Estado;
import ex01.state.Pular;

public class Jogador {
    private String nome;
    private Estado estado;

    private Estado[] objetivos = {
            new Correr(this),
            new Pular(this),
            new Pular(this),
    };
    private int objetivoAtual = 0;

    public Jogador(String nome) {
        this.nome = nome;
        this.estado = new Esperar(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() throws JogadorMortoException {
        return estado;
    }

    public void setEstado(Estado estado) throws JogadorMortoException {
        String objetivoQueDeveriaFazer = objetivos[objetivoAtual].getMsg();

        if (estado.getMsg().equals(objetivoQueDeveriaFazer)) {
            System.out.println("Objetivo " + objetivoQueDeveriaFazer + " concluído!\n");
            objetivoAtual++;
            if (objetivoAtual == objetivos.length) {
                System.out.println("Todos os objetivos concluídos! Parabéns!");
                System.exit(0);
            }
        } else {
            System.out.println("Você deveria " + objetivoQueDeveriaFazer + "!");
            System.out.println("Mas, você está " + estado.getMsg() + "!");
            System.out.println("Você morreu! :(");
            throw new JogadorMortoException("Você morreu!");
        }

        this.estado = estado;
    }

}
