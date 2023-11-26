package ex02.loja;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {
    private static final int ESTADO_PEDIDO_CRIADO = 0;
    private static final int ESTADO_PEDIDO_PAGAMENTO_CONFIRMADO = 1;
    private static final int ESTADO_PEDIDO_EM_PREPARACAO = 2;
    private static final int ESTADO_PEDIDO_ENVIADO = 3;
    private static final int ESTADO_PEDIDO_CANCELADO = 4;
    private static final int SAIR = 5;

    public Cliente clienteAtual;
    public Produto[] produtos = {
            new Produto().ChaveDeFenda(),
            new Produto().ChapeuDePirata(),
            new Produto().PeDePato(),
    };

    public Loja() {
    }

    public void iniciarVendas() {
        try (Scanner input = new Scanner(System.in)) {
            this.clienteAtual = this.perguntarNomeCliente(input);
            // Quebra de linha
            System.out.println();

            Pedido pedido = this.novoPedido(input);
            // Quebra de linha
            System.out.println();

            System.out.println("Pedido " + pedido.getId() + " criado com sucesso!");
            // Quebra de linha
            System.out.println();

            int opcao = ESTADO_PEDIDO_CRIADO;
            while (opcao != SAIR) {
                opcao = mudarEstadoPedido(pedido, input);
            }
            // Quebra de linha
            System.out.println();

            System.out.println("Resumo pedido: " + pedido.toString());
        } catch (Exception e) {
            System.out.println("Parece que houve um erro. Tente novamente.");
            this.iniciarVendas();
        }
    }

    public Cliente perguntarNomeCliente(Scanner input) {
        try {
            System.out.println("Nome cliente:");
            String nome = input.nextLine();
            return new Cliente(nome);
        } catch (Exception e) {
            System.out.println("Parece que houve um erro. Tente novamente.");
            return perguntarNomeCliente(input);
        }
    }

    public Pedido novoPedido(Scanner input) {
        ArrayList<Produto> sacola = new ArrayList<Produto>();
        try {
            // Looping infinito para adicionar produtos na sacola
            while (true) {
                sacola.add(adicionarProdutoNaSacola(input));
            }
        } catch (SacolaFinalizadaException e) {
            // Transforma id numérico em string: ex: 1 -> #1
            String idPedido = "#" + String.valueOf(this.clienteAtual.getPedidos().length);
            return new Pedido(idPedido, this.clienteAtual.getNome(), sacola);
        } catch (Exception e) {
            System.out.println("Parece que houve um erro. Tente novamente.");
            return novoPedido(input);
        }
    }

    public Produto adicionarProdutoNaSacola(Scanner input) throws SacolaFinalizadaException {
        System.out.println("Digite o número do produto que deseja comprar:");
        for (int i = 0; i < this.produtos.length; i++) {
            System.out.println("[" + i + "] " + this.produtos[i].getNome());
        }
        int idProduto = input.nextInt();

        int SIM = 1;
        int NAO = 2;
        System.out.println("Deseja adicionar mais algum produto?");
        System.out.println("[" + SIM + "] Sim");
        System.out.println("[" + NAO + "] Não");
        int opcao = input.nextInt();
        if (opcao == NAO) {
            throw new SacolaFinalizadaException();
        }

        return this.produtos[idProduto];
    }

    public int mudarEstadoPedido(Pedido pedido, Scanner input) {
        try {
            System.out.println("Qual o novo estado do pedido " + pedido.getId() + "?");
            System.out.println("[" + ESTADO_PEDIDO_PAGAMENTO_CONFIRMADO + "] Pagamento confirmado");
            System.out.println("[" + ESTADO_PEDIDO_EM_PREPARACAO + "] Em Preparação");
            System.out.println("[" + ESTADO_PEDIDO_ENVIADO + "] Enviado");
            System.out.println("[" + ESTADO_PEDIDO_CANCELADO + "] Cancelado");
            System.out.println("[" + SAIR + "] Sair");

            int opcao = input.nextInt();
            switch (opcao) {
                case ESTADO_PEDIDO_PAGAMENTO_CONFIRMADO:
                    pedido.getEstado().pedidoPagamentoConfirmado();
                    return ESTADO_PEDIDO_PAGAMENTO_CONFIRMADO;
                case ESTADO_PEDIDO_EM_PREPARACAO:
                    pedido.getEstado().pedidoEmPreparacao();
                    return ESTADO_PEDIDO_EM_PREPARACAO;
                case ESTADO_PEDIDO_ENVIADO:
                    pedido.getEstado().pedidoEnviado();
                    return ESTADO_PEDIDO_ENVIADO;
                case ESTADO_PEDIDO_CANCELADO:
                    pedido.getEstado().pedidoCancelado();
                    return ESTADO_PEDIDO_CANCELADO;
                case SAIR:
                    return SAIR;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Parece que houve um erro. Tente novamente.");
            return mudarEstadoPedido(pedido, input);
        }
    }

}
