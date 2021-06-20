package challenge;


import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            temIdadeNegativa(idade);
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            temPontosNegativos(pontos);
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
            Motorista motorista = new Motorista(nome, idade, pontos, habilitacao);
            naoTemNome(motorista);
            naoTemHabilitacao(motorista);
            return motorista;
        }
    }

    private static void naoTemNome(Motorista motorista) throws NullPointerException {
        if (motorista.nome == null) {
            throw new NullPointerException();
        }
    }

    private static void naoTemHabilitacao(Motorista motorista) throws NullPointerException {
        if (motorista.habilitacao == null) {
            throw new NullPointerException();
        }
    }

    private static void temPontosNegativos(int pontos) throws IllegalArgumentException {
        if (pontos < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void temIdadeNegativa(int idade) throws IllegalArgumentException {
        if (idade < 0) {
            throw new IllegalArgumentException();
        }
    }
}
