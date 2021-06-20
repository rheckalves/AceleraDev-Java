package br.com.codenation.times;

import br.com.codenation.jogadores.Jogador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Time {
    private final Long id;
    private final String nome;
    private ArrayList<Jogador> listaJogadores = new ArrayList<>();

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
    }
    public void adicionarJogador(Jogador jogador) {
        listaJogadores.add(jogador);
    }

    public Long retornaCapitaoDoTime() {
        Long capitao = null;
        for (Jogador jogador : listaJogadores) {
            if (jogador.getCapitao()) {
                capitao = jogador.getId();
            }
        }
        return capitao;
    }

    public Long retornaJogadorMaiorSalario() {
        Long jogadorMaiorSalario = null;
        BigDecimal maiorSalario;
        ArrayList<BigDecimal> listaSalarios = new ArrayList<>();
        for (Jogador jogador : listaJogadores) {
            listaSalarios.add(jogador.getSalario());
        }
        maiorSalario = Collections.max(listaSalarios);
        for (Jogador jogador : listaJogadores) {
            if (jogador.getSalario().equals(maiorSalario)) {
                jogadorMaiorSalario = jogador.getId();
            }
        }
        return jogadorMaiorSalario;
    }

    public Long retornaJogadorMaisVelho() {
        Long jogadorMaisVelho = null;
        Integer maiorIdade;
        ArrayList<Integer> listaIdades = new ArrayList<>();
        for (Jogador jogador : listaJogadores) {
            listaIdades.add(jogador.getIdade());
        }
        maiorIdade = Collections.max(listaIdades);
        for (Jogador jogador : listaJogadores) {
            if (jogador.getIdade().equals(maiorIdade)) {
                jogadorMaisVelho = jogador.getId();
            }
        }
        return jogadorMaisVelho;
    }

    public Long retornaMelhorJogador() {
        Long melhorJogadorId = null;
        Integer maiorValorHabilidade;
        ArrayList<Integer> listaHabilidades = new ArrayList<>();
        for (Jogador jogador : listaJogadores) {
            listaHabilidades.add(jogador.getNivelHabilidade());
        }
        maiorValorHabilidade = Collections.max(listaHabilidades);
        for (Jogador jogador : listaJogadores) {
            if (jogador.getNivelHabilidade().equals(maiorValorHabilidade)) {
                melhorJogadorId = jogador.getId();
            }
        }
        return melhorJogadorId;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Jogador> getListaJogadores() {
        return listaJogadores;
    }

}

