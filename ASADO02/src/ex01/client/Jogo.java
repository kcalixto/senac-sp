package ex01.client;

import java.util.Scanner;

public class Jogo {
    private static final int ACAO_NENHUMA = 0;
    private static final int ACAO_CORRER = 1;
    private static final int ACAO_ESPERAR = 2;
    private static final int ACAO_PULAR = 3;
    private static final int ACAO_SAIR = 4;

    public Jogo() {
    }

    public void comecarJogo() {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Digite o nome do jogador 1: ");
            Jogador j1 = new Jogador(s.nextLine());
            System.out.println("Jogador 1: " + j1.getNome());

            mostrarObjetivos(j1);

            int acao = ACAO_NENHUMA;
            while (acao != ACAO_SAIR) {
                System.out.println(String.format("%s - Estado atual: %s\n", j1.getNome(), j1.getEstado().getMsg()));
                acao = perguntarAcao(s, j1);
            }
        } catch (JogadorMortoException e) {
            System.exit(0);
        }
    }

    private void mostrarObjetivos(Jogador j1) {
        System.out.println(String.format(
                "Olá %s, vamos começar o jogo!\n Suas missões são: Correr 1 vezes e Pular 2 vezes, se você Correr duas vezes cairá em algum buraco e morrerá instantânemanete!",
                j1.getNome()));
    }

    private int perguntarAcao(Scanner s, Jogador j1) throws JogadorMortoException {
        try {
            System.out.println("Qual ação deseja realizar? (1) Correr (2) Esperar (3) Pular (4) Sair");
            int acao = s.nextInt();
            switch (acao) {
                case ACAO_CORRER:
                    j1.getEstado().correr();
                    return ACAO_CORRER;
                case ACAO_ESPERAR:
                    j1.getEstado().esperar();
                    return ACAO_ESPERAR;
                case ACAO_PULAR:
                    j1.getEstado().pular();
                    return ACAO_PULAR;
                case ACAO_SAIR:
                    System.out.println("Saindo...");
                    return 4;
                default:
                    throw new Exception();
            }
        } catch (JogadorMortoException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Ação inválida, por favor tente novamente.");
            return perguntarAcao(s, j1);
        }
    }

}
