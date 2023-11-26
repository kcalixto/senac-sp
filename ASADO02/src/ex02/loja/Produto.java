package ex02.loja;

public class Produto {
    public Produto() {
    }

    public String getId() {
        return "desconhecido";
    }

    public String getNome() {
        return "desconhecido";
    }

    public double getQuantidade() {
        return 0.0;
    }

    public class ProdutoChaveDeFenda extends Produto {
        public static final String ID = "01";
        public static final String NOME = "Chave de fenda";
        public static final double QUANTIDADE = 1.0;

        public ProdutoChaveDeFenda() {
        }

        public String getId() {
            return ID;
        }

        public String getNome() {
            return NOME;
        }

        public double getQuantidade() {
            return QUANTIDADE;
        }
    }

    public class ProdutoChapeuDePirata extends Produto {
        public static final String ID = "02";
        public static final String NOME = "Chapéu de pirata";
        public static final double QUANTIDADE = 1.0;

        public ProdutoChapeuDePirata() {
        }

        public String getId() {
            return ID;
        }

        public String getNome() {
            return NOME;
        }

        public double getQuantidade() {
            return QUANTIDADE;
        }
    }

    public class ProdutoPeDePato extends Produto {
        public static final String ID = "03";
        public static final String NOME = "Pé de Pato";
        public static final double QUANTIDADE = 1.0;

        public ProdutoPeDePato() {
        }

        public String getId() {
            return ID;
        }

        public String getNome() {
            return NOME;
        }

        public double getQuantidade() {
            return QUANTIDADE;
        }
    }

    public Produto ChaveDeFenda() {
        return new ProdutoChaveDeFenda();
    }

    public Produto ChapeuDePirata() {
        return new ProdutoChapeuDePirata();
    }

    public Produto PeDePato() {
        return new ProdutoPeDePato();
    }
}
